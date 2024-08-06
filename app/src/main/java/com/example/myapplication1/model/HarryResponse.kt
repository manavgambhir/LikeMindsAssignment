package com.example.myapplication1.model

data class HarryResponse(
	val response: List<ResponseItem?>? = null
)

data class ResponseItem(
	val image: String? = null,
	val birthdate: String? = null,
	val children: List<String?>? = null,
	val nickname: String? = null,
	val fullName: String? = null,
	val index: Int? = null,
	val hogwartsHouse: String? = null,
	val interpretedBy: String? = null
)

