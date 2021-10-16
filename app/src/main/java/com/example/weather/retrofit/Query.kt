package com.example.weather.retrofit

import com.example.weather.models.WeatherDataClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Query {
    @GET("data/2.5/weather")
    fun getWeatherList(
        @Query("5d120d716ff645fd1975314e1f1c78cd") key:String
    ):Call<WeatherDataClass>

}