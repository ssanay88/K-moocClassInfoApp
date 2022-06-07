package com.example.k_moocclassinfoapp.acitivities.api

import com.example.k_moocclassinfoapp.acitivities.model.LectureList
import retrofit2.Call
import retrofit2.http.GET

interface KmoocApi {

    @GET("http://apis.data.go.kr/B552881/kmooc")
    fun getLecture(

    ) : Call<LectureList>

}