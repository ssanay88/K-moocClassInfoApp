package com.example.k_moocclassinfoapp.acitivities.repositories

import com.example.k_moocclassinfoapp.BuildConfig
import com.example.k_moocclassinfoapp.acitivities.api.RetrofitInstance
import com.example.k_moocclassinfoapp.acitivities.model.Lecture
import com.example.k_moocclassinfoapp.acitivities.model.LectureList
import retrofit2.Call
import retrofit2.http.POST

// 데이터에 접근하기 위한 Repository, 여기를 통해서 어떤 방식의 데이터든 접근
class Repository {

    fun getLectureList() : Call<LectureList> {
        return RetrofitInstance.kmoocApi.getLectureList(BuildConfig.DATA_API_KEY,1)
    }

    fun getLectureDetail() : Call<Lecture> {
        return RetrofitInstance.kmoocApi.getLectureDetail(BuildConfig.DATA_API_KEY,"course-v1:FUNMOOC+test1+test1")
    }

}