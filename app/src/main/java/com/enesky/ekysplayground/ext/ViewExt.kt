package com.enesky.ekysplayground.ext

import android.view.View
import android.view.animation.Animation

/**
 * Created by Enes Kamil YILMAZ on 14/03/2021
 */

fun View.startAnimation(animation: Animation, onAnimStart: () -> Unit, onAnimEnd: () -> Unit) {
    animation.setAnimationListener(object: Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation?) = onAnimStart()
        override fun onAnimationEnd(animation: Animation?) = onAnimEnd()
        override fun onAnimationRepeat(animation: Animation?) = Unit
    })
    startAnimation(animation)
}