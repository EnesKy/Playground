package com.enesky.ekysplayground.ext

import android.view.View
import android.view.animation.Animation

/**
 * Created by Enes Kamil YILMAZ on 14/03/2021
 */

fun View.startAnim(animation: Animation, onAnimEnd: () -> Unit) {
    animation.setAnimationListener(object: Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation?) = Unit
        override fun onAnimationEnd(animation: Animation?) = onAnimEnd()
        override fun onAnimationRepeat(animation: Animation?) = Unit
    })
    startAnimation(animation)
}