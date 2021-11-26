package com.example.weather.koin

import com.example.weather.ui.WeatherPresenter
import org.koin.core.module.Module
import org.koin.dsl.module

object MainModule {
    fun create():Module = module {
        factory { WeatherPresenter(get()) }
    }
}