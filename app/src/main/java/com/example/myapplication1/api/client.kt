package com.example.myapplication1.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object client {
    val gson:Gson = GsonBuilder().create()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://potterapi-fedeperin.vercel.app")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val api = retrofit.create(service::class.java)
}