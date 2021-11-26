package com.example.weather.mvp

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.annotation.AnimRes
import androidx.fragment.app.Fragment

private const val EXTRA_OVERRIDDEN_ENTER_ANIMATION = "EXTRA_OVERRIDDEN_ENTER_ANIMATION"
private const val EXTRA_OVERRIDDEN_EXIT_ANIMATION = "EXTRA_OVERRIDDEN_EXIT_ANIMATION"


abstract class BaseFragment : Fragment(),
    BaseFragmentContract {
    override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation? {
        val extra = if (enter) EXTRA_OVERRIDDEN_ENTER_ANIMATION else EXTRA_OVERRIDDEN_EXIT_ANIMATION
        val animRes = arguments?.getInt(extra)?.takeIf { it != 0 }
            ?: return super.onCreateAnimation(transit, enter, nextAnim)

        requireArguments().remove(extra)

        return AnimationUtils.loadAnimation(requireContext(), animRes)
    }

    override fun overrideEnterAnimation(@AnimRes animation: Int) {
        overrideAnimation(animation, EXTRA_OVERRIDDEN_ENTER_ANIMATION)
    }

    override fun overrideExitAnimation(@AnimRes animation: Int) {
        overrideAnimation(animation, EXTRA_OVERRIDDEN_EXIT_ANIMATION)
    }

    private fun overrideAnimation(@AnimRes animation: Int, extraKey: String) {
        arguments = (arguments ?: Bundle()).apply { putInt(extraKey, animation) }
    }

//    fun changeFragment(fragment: Fragment, id: Int) {
//        val fragmentManager = requireActivity().supportFragmentManager
//        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.addToBackStack(null)
//        fragmentTransaction.replace(R.id.frame_layout, fragment)
//        fragmentTransaction.commit()
//    }
//
//    fun isValidEmail(email: String): Boolean {
//        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
//    }
}