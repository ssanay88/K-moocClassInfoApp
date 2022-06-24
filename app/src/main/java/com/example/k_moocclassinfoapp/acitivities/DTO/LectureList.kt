package com.example.k_moocclassinfoapp.acitivities.DTO

import com.example.k_moocclassinfoapp.acitivities.model.Pagination
import com.example.k_moocclassinfoapp.acitivities.model.Lecture
import com.google.gson.annotations.SerializedName

data class LectureList(
    val pagination: Pagination,
    @SerializedName("results") var Lectures: List<Lecture>
)