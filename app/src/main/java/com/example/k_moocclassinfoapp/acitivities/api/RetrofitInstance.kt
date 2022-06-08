package com.example.k_moocclassinfoapp.acitivities.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// 싱글톤으로 객체 생성
object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://apis.data.go.kr/B552881/kmooc")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val kmoocApi : KmoocApi by lazy {
        retrofit.create(KmoocApi::class.java)
    }

}