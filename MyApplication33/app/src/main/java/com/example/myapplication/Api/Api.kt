package com.example.myapplication.Api


import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface Api {
    companion object{
        val URL = "https://iis.ngknn.ru/NGKNN/МамшеваЮС/MedicMadlab/"
    }
    @Headers("Content-Type: application/json")
    @POST("api/SendCode")
    suspend fun CodeEmail(@Body email: String):String
    @Headers("Content-Type: application/json")
    @POST("api/SignIn")
    suspend fun signInCode(@Body signInRequest: SignInRequest): String
}

data class SignInRequest(
    val code: String,
    val email: String
)


