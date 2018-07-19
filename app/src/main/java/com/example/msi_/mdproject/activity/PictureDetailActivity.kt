package com.example.msi_.mdproject.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.example.msi_.mdproject.R

/**
 *@Author：ZC
 *@Time： 2018/7/17 15:58
 *@Description：图片详细信息展示页面
 **/
class PictureDetailActivity:AppCompatActivity(){
    private lateinit var ivContent:ImageView
    private lateinit var tvContent:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture_detail)
        initView()
        init()
    }

    private fun initView(){
        ivContent = findViewById(R.id.iv_content)
        tvContent = findViewById(R.id.tv_content)
    }

    private fun init(){
        title = "列表展示"
        ivContent.setImageResource(R.mipmap.ic_launcher_round)
        ivContent.setOnClickListener{
            onBackPressed()
        }
    }
}