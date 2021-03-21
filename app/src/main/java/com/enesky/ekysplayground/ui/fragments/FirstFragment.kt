package com.enesky.ekysplayground.ui.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.enesky.ekysplayground.R
import com.enesky.ekysplayground.databinding.FragmentFirstBinding
import com.enesky.ekysplayground.ext.startAnimation

class FirstFragment : Fragment(R.layout.fragment_first) {

    private lateinit var binding: FragmentFirstBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFirstBinding.bind(view)

        val animation = AnimationUtils.loadAnimation(context, R.anim.fill_screen).apply {
            duration = 500
            interpolator = AccelerateDecelerateInterpolator()
        }

        binding.fab.setOnClickListener {
            binding.fab.isVisible = false
            binding.circle.isVisible = true
            binding.circle.startAnimation(
                animation = animation,
                onAnimStart = {
                    Handler(Looper.getMainLooper()).postDelayed({
                        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
                    }, 300)
                },
                onAnimEnd = {
                    binding.circle.isVisible = false
                }
            )
        }

        binding.fab2.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_ThirdFragment)
        }

    }

}