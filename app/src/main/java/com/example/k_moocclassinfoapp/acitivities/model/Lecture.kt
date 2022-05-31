package com.example.k_moocclassinfoapp.acitivities.model

import java.io.Serializable
import java.util.*

data class Lecture(
    val id: String,
    val number: String,
    val name: String,
    val classfyName: String,
    val middleClassfyName: String,
    val courseImage: String,
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