package com.example.k_moocclassinfoapp.acitivities

import android.app.Application
import com.example.k_moocclassinfoapp.acitivities.repositories.Repository

class LectureApplication : Application() {
    val repository = Repository()
}