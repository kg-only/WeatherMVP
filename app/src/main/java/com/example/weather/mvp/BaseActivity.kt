package com.example.weather.mvp

import androidx.appcompat.app.AppCompatActivity
import com.example.weather.R

abstract class BaseActivity : AppCompatActivity() {

    fun replaceFragment(fragment: androidx.fragment.app.Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment)
        transaction.commit()
    }
}