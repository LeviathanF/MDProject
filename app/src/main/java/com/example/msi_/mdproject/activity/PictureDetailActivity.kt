package com.example.msi_.mdproject.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.example.msi_.mdproject.R

/**
 *@Author：ZC
 *@Time： 2018/7/17 15:58
 *@Description：
 **/
class PictureDetailActivity:AppCompatActivity(){
    private lateinit var ivContent:ImageView
    private lateinit var tvContent:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture_detail)
    }

    private fun initView(){
        ivContent = findViewById(R.id.iv_content)
        tvContent = findViewById(R.id.tv_content)
    }
}