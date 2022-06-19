package com.example.k_moocclassinfoapp.acitivities.activities.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.k_moocclassinfoapp.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {

    private lateinit var detailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)
    }
}