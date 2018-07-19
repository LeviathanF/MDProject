package com.example.msi_.mdproject.activity

import android.animation.TimeInterpolator
import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.support.v7.widget.RecyclerView
import android.view.ViewAnimationUtils
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import com.example.msi_.mdproject.R
import kotlin.math.max

/**
 *@Author：ZC
 *@Time： 2018/7/17 16:24
 *@Description：
 **/
class AnimationActivity:AppCompatActivity(){
    private lateinit var iv1:ImageView
    private lateinit var iv2:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
        initView()
        init()
    }

    private fun initView(){
        iv1 = findViewById(R.id.iv1)
        iv2 = findViewById(R.id.iv2)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun init(){
        title = "渐变动画"
        iv1.setOnTouchListener { view, motionEvent ->
            val animation = ViewAnimationUtils.createCircularReveal(iv1,
                    motionEvent.x.toInt(),motionEvent.y.toInt()
                    ,0f, Math.max(iv1.width,iv1.height)*1.2.toFloat()
            )
            animation.setDuration(1000)
            animation.interpolator = AccelerateDecelerateInterpolator()
            animation.start()
            true
        }
//        iv1.setOnClickListener {
//            iv1.setBackgroundColor(Color.GRAY)
//            val animation = ViewAnimationUtils.createCircularReveal(iv1,
//                    iv1.width/2,iv1.height/2
//            ,0f, Math.max(iv1.width,iv1.height).toFloat()
//            )
//            animation.setDuration(2000)
//            animation.interpolator = AccelerateDecelerateInterpolator()
//            animation.start()
//        }
        iv2.setOnClickListener {
            val animation = ViewAnimationUtils.createCircularReveal(iv2,
                    0,0,0f, max(iv2.width,iv2.height)*1.5.toFloat())
            animation.setDuration(2000)
            animation.interpolator = AccelerateDecelerateInterpolator()
            animation.start()
        }
    }
}