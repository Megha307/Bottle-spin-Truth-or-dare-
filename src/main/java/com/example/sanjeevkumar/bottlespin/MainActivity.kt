package com.example.sanjeevkumar.bottlespin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth



class MainActivity : AppCompatActivity() {
    var random=Random()
    var lastDir:Float = 0.0f
    var spinning:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun spinBottle(v: View) {
        if (!spinning) {
            val newDir = random.nextInt(1800)
            val pivotX = bottle.width / 2
            val pivotY = bottle.height / 2

            val rotate = RotateAnimation(lastDir, newDir.toFloat(), pivotX.toFloat(), pivotY.toFloat())
            rotate.duration = 2500
            rotate.fillAfter = true
            rotate.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {
                    spinning = true
                }

                override fun onAnimationEnd(animation: Animation) {
                    spinning = false
                }

                override fun onAnimationRepeat(animation: Animation) {

                }
            })

            lastDir = newDir.toFloat()
            bottle.startAnimation(rotate)
        }
    }

        }


