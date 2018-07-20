package com.example.msi_.mdproject.BaseActivity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.greenrobot.eventbus.EventBus

/**
 *@Author：ZC
 *@Time： 2018/7/20 11:24
 *@Description：基础的封装Activity
 **/
abstract class BaseActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initView()
        init()
        initToolsbar()
        initRv()
    }



    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    abstract fun getLayoutId():Int

    abstract fun initView()

    abstract fun init()

    abstract fun initToolsbar()

    open fun initRv(){}
}