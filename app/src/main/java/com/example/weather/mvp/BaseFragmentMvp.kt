package com.example.weather.mvp

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper

abstract class BaseFragmentMvp<V : MvpView, P : MvpPresenter<V>>(
) : BaseFragment(), MvpView {
    abstract val presenter: P

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        @Suppress("UNCHECKED_CAST")
        presenter.attach(this as V)
    }

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detach()
    }
}