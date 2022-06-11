package com.example.k_moocclassinfoapp.acitivities.DTO

import com.example.k_moocclassinfoapp.acitivities.model.Pagination
import com.example.k_moocclassinfoapp.acitivities.model.Lecture

data class LectureList(
    val pagination: Pagination,
    val Lectures: List<Lecture>
)