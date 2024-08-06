package com.example.myapplication1.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object client {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://potterapi-fedeperin.vercel.app")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val services = retrofit.create(service::class.java)
}