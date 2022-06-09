package com.example.k_moocclassinfoapp.acitivities.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.k_moocclassinfoapp.BuildConfig
import com.example.k_moocclassinfoapp.acitivities.api.RetrofitInstance
import com.example.k_moocclassinfoapp.acitivities.model.Lecture
import com.example.k_moocclassinfoapp.acitivities.model.LectureList
import com.example.k_moocclassinfoapp.acitivities.singletone.singletoneWord
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.POST

// 데이터에 접근하기 위한 Repository, 여기를 통해서 어떤 방식의 데이터든 접근
class Repository {

    fun getLectureList() : LiveData<LectureList> {

        val lectureList = MutableLiveData<LectureList>()
        RetrofitInstance.kmoocApi.getLectureList(BuildConfig.DATA_API_KEY,1)
            .enqueue(object : Callback<LectureList>{
                override fun onResponse(call: Call<LectureList>, response: Response<LectureList>) {
                    if (response.isSuccessful.not()) {
                        Log.e(singletoneWord.logTag, "응답에 실패했습니다.")
                    }

                    lectureList = response.body()
                }

                override fun onFailure(call: Call<LectureList>, t: Throwable) {
                    Log.d(singletoneWord.logTag,"API 통신 실패 : $t")
                }

            })



        return lectureList
    }

    fun getLectureDetail() : Call<Lecture> {
        return RetrofitInstance.kmoocApi.getLectureDetail(BuildConfig.DATA_API_KEY,"course-v1:FUNMOOC+test1+test1")
    }

}