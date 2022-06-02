package com.example.k_moocclassinfoapp.acitivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.k_moocclassinfoapp.R
import com.example.k_moocclassinfoapp.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var detailBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)
    }
}