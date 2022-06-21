package com.example.k_moocclassinfoapp.acitivities.api

import com.example.k_moocclassinfoapp.acitivities.DTO.LectureList
import com.example.k_moocclassinfoapp.acitivities.model.Lecture
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface KmoocApi {

    @GET("/B552881/kmooc/courseList")
    fun getLectureList(
        @Query("serviceKey") serviceKey: String,
        @Query("page") page: Int
    ) : Call<LectureList>

    @GET("/B552881/kmooc/courseDetail")
    fun getLectureDetail(
        @Query("serviceKey") serviceKey: String,
        @Query("courseId") courseId: String
    ) : Call<Lecture>

}