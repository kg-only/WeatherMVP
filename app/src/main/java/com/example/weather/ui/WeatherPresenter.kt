package com.example.weather.ui

import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.weather.models.WeatherDataClass
import com.example.weather.mvp.BasePresenter
import com.example.weather.retrofit.RetrofitService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.koin.ext.scope
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherPresenter(private val api: RetrofitService) : BasePresenter<WeatherContract.View>(),
    WeatherContract.Presenter {
    private val presenterScope = CoroutineScope(Dispatchers.Main.immediate)

    override fun loadWeather(city: String) {
        presenterScope.launch {
            api.getWeatherList(city).enqueue(object : Callback<WeatherDataClass> {
                override fun onResponse(
                    call: Call<WeatherDataClass>,
                    response: Response<WeatherDataClass>,
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        val data = response.body()!!
                        view?.getWeatherFromView(data)
                }
            }
                    override fun onFailure(call: Call<WeatherDataClass>, t: Throwable) {
                Log.e("Failure", "fail")
            }
        })
    }
}
}
