package com.example.weather.retrofit

import com.example.weather.models.WeatherDataClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Query {
        //    https://api.openweathermap.org/data/2.5/weather?q=Moscow&appid=42e1fb65aa9d7209eb6dfc56760ea031

        @GET("data/2.5/weather?")
        fun getWeatherList(
            @Query("q") city: String,
            @Query("appid") key: String,
            @Query("units") units: String,
            @Query("lang") lang: String
        ): Call<WeatherDataClass>

    }