package com.example.k_moocclassinfoapp.acitivities.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LectureList(
    @SerializedName("count") val count: Int,
    @SerializedName("num_pages") val numPages: Int,
    @SerializedName("previous") val previous: String,
    @SerializedName("next") val next: String,
    var lecture: List<Lecture>
) : Serializable