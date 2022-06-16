package com.example.k_moocclassinfoapp.acitivities.repositories

import android.net.UrlQuerySanitizer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.k_moocclassinfoapp.BuildConfig
import com.example.k_moocclassinfoapp.acitivities.DTO.LectureList
import com.example.k_moocclassinfoapp.acitivities.api.RetrofitInstance
import com.example.k_moocclassinfoapp.acitivities.model.Lecture
import com.example.k_moocclassinfoapp.acitivities.singletone.singletoneWord
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// 데이터에 접근하기 위한 Repository, 여기를 통해서 어떤 방식의 데이터든 접근
class Repository {

    fun getLectureList(key : String, page : Int) : LiveData<LectureList> {

        val lectureList = MutableLiveData<LectureList>()

        RetrofitInstance.kmoocApi.getLectureList(key, page)
            .enqueue(object : Callback<LectureList>{
                override fun onResponse(call: Call<LectureList>, response: Response<LectureList>) {

                    if (response.isSuccessful.not()) {
                        Log.e(singletoneWord.logTag, "응답에 실패했습니다.")
                    }

                    response.body().let {
                        Log.d(singletoneWord.logTag,"$it")
                        lectureList.postValue(it)
                    }
                }

                override fun onFailure(call: Call<LectureList>, t: Throwable) {
                    Log.d(singletoneWord.logTag,"API 통신 실패 : $t")
                }
            })

        return lectureList
    }

    fun getLectureDetail(key: String, courseId: String) : LiveData<Lecture> {

        val lecture = MutableLiveData<Lecture>()

        RetrofitInstance.kmoocApi.getLectureDetail(key,courseId)
            .enqueue(object : Callback<Lecture>{
                override fun onResponse(call: Call<Lecture>, response: Response<Lecture>) {

                    if (response.isSuccessful.not()) {
                        Log.e(singletoneWord.logTag, "응답에 실패했습니다.")
                    }

                    response.body().let {
                        Log.d(singletoneWord.logTag,"$it")
                        lecture.postValue(it)
                    }
                }

                override fun onFailure(call: Call<Lecture>, t: Throwable) {
                    Log.d(singletoneWord.logTag,"API 통신 실패 : $t")
                }

            })

        return lecture
    }

    fun next(currentPage : LectureList, completed: (LectureList) -> Unit) {
        val nextPage = currentPage.pagination.next    // 다음 페이지
        val urlSanitizer = UrlQuerySanitizer(nextPage)
        val pageNum = urlSanitizer.getValue("page")
        val nextLecturs = getLectureList(BuildConfig.DATA_API_KEY, pageNum.toInt()).value
        if (nextLecturs != null) completed(nextLecturs)
    }

    fun list(completed: (LectureList) -> Unit) {
        val Lectures = getLectureList(BuildConfig.DATA_API_KEY, 1).value
        if (Lectures != null) completed(Lectures)
    }

}