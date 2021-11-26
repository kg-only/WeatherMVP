package com.example.weather.retrofit

import com.example.weather.models.WeatherDataClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
        //    https://api.openweathermap.org/data/2.5/weather?q=Moscow&appid=5d120d716ff645fd1975314e1f1c78cd&units=metric&lang=ru

        @GET("data/2.5/weather?appid=5d120d716ff645fd1975314e1f1c78cd&units=metric&lang=ru")
        fun getWeatherList(@Query("q") city: String): Call<WeatherDataClass>
    }
