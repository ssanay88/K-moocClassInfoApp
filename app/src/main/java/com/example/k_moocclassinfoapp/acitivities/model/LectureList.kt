package com.example.k_moocclassinfoapp.acitivities.model

import java.io.Serializable

data class LectureList(
    val count: Int,
    val numPages: Int,
    val previous: String,
    val next: String,
    var lecture: List<Lecture>
) : Serializable