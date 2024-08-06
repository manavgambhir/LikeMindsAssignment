package com.example.myapplication1.api

import com.example.myapplication1.model.HarryResponse
import retrofit2.Response
import retrofit2.http.GET

interface service {
    @GET("/en/characters")
    suspend fun getData(): Response<HarryResponse>
}