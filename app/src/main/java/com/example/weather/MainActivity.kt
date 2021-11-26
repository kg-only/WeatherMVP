package com.example.weather

import android.os.Bundle
import com.example.weather.R
import com.example.weather.mvp.BaseActivity
import com.example.weather.ui.WeatherFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(WeatherFragment())
    }
}