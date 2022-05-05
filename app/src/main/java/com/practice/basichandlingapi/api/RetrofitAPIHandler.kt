package com.practice.basichandlingapi.api

import com.practice.basichandlingapi.models.Photo
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitAPIHandler {

    @GET("photos")
    fun getPhotos(): Call<List<Photo>>

    companion object {

        val API_URL = "https://jsonplaceholder.typicode.com"

        fun create(): RetrofitAPIHandler {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(API_URL)
                .build()
            return retrofit.create(RetrofitAPIHandler::class.java)
        }
    }
}