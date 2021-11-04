package com.example.weather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weather.retrofit.RetrofitClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, WeatherFragment())
        transaction.commit()

    }
}