package com.example.weather.ui

import com.example.weather.models.WeatherDataClass
import com.example.weather.mvp.MvpPresenter
import com.example.weather.mvp.MvpView
import retrofit2.Call

interface WeatherContract {
    interface View : MvpView {
         fun getWeatherFromView(item: WeatherDataClass)
    }

    interface Presenter : MvpPresenter<View> {
        fun loadWeather(city:String)
    }
}