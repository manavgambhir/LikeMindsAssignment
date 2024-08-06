package com.example.myapplication1.repos

import com.example.myapplication1.api.client

object repository {
    suspend fun getData() = client.services.getData()
}