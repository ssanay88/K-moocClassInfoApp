package com.example.k_moocclassinfoapp.acitivities.api

import com.example.k_moocclassinfoapp.acitivities.DTO.LectureList
import com.example.k_moocclassinfoapp.acitivities.model.Lecture
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface KmoocApi {

    @GET("/courseList")
    fun getLectureList(
        @Query("ServiceKey") serviceKey: String,
        @Query("Page") page: Int,
    ) : Call<LectureList>

    @GET("/courseDetail")
    fun getLectureDetail(
        @Query("ServiceKey") serviceKey: String,
        @Query("CourseId") courseId: String,
    ) : Call<Lecture>

}