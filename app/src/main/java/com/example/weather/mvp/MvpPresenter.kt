package com.example.weather.mvp

interface MvpPresenter<V : MvpView> {
    fun attach(view: V)
    fun detach()
}