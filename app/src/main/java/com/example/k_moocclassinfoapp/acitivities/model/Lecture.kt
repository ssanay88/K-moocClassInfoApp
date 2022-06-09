package com.example.k_moocclassinfoapp.acitivities.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

data class Lecture(
    @SerializedName("id") val id: String,
    @SerializedName("Number") val number: String,
    @SerializedName("name") val name: String,
    @SerializedName("classfy_name") val classfyName: String,
    @SerializedName("middle_classfy_name") val middleClassfyName: String,
    @SerializedName("") val courseImage: String,
    val courseImageLarge: String,
    val shortDescription: String,
    val orgName: String,
    val start: Date,
    val end: Date,
    val teachers: String?,
    val overview: String?,
) : Serializable {
    companion object {
        val EMPTY = Lecture(
            "", "", "", "", "", "", "", "", Date(), Date(), null, null
        )
    }
}