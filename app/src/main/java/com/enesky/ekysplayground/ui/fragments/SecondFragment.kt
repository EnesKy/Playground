package com.enesky.ekysplayground.ui.fragments

import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.enesky.ekysplayground.R
import com.enesky.ekysplayground.databinding.FragmentSecondBinding
import com.enesky.ekysplayground.ext.startAnimation

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */

class SecondFragment : Fragment(R.layout.fragment_second) {

    private lateinit var binding: FragmentSecondBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSecondBinding.bind(view)

        setClickListeners()
        setOnBackPressCallback()
    }

    private fun setClickListeners() {
        val animation = AnimationUtils.loadAnimation(context, R.anim.anim_defill_screen).apply {
            duration = 500
            interpolator = AccelerateDecelerateInterpolator()
        }

        binding.fab.setOnClickListener {
            binding.clRoot.background = ContextCompat.getDrawable(it.context, android.R.color.transparent)
            binding.circle.isVisible = true
            binding.circle.startAnimation(
                animation = animation,
                onAnimStart = {
                    binding.textviewSecond.isVisible = false
                    binding.fab.isVisible = false
                },
                onAnimEnd = {
                    binding.circle.isVisible = false
                    findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
                }
            )
        }
    }

    private fun setOnBackPressCallback() {
        activity?.onBackPressedDispatcher?.addCallback(
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (findNavController().currentDestination?.label == getString(R.string.second_fragment_label))
                        binding.fab.performClick()
                    else
                        findNavController().navigateUp()
                }
            }
        )
    }

}