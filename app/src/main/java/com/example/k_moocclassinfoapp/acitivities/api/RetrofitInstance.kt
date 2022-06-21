package com.example.k_moocclassinfoapp.acitivities.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// 싱글톤으로 객체 생성
object RetrofitInstance {

    private val retrofit by lazy {

        var gson = GsonBuilder().setLenient().create()

        Retrofit.Builder()
            .baseUrl("http://apis.data.go.kr")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val kmoocApi : KmoocApi by lazy {
        retrofit.create(KmoocApi::class.java)
    }

}