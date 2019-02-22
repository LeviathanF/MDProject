package com.example.msi_.mdproject.activity

import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import com.example.msi_.mdproject.BaseActivity.BaseActivity
import com.example.msi_.mdproject.R
import com.example.msi_.mdproject.adapter.HeadViewAdapter

/**
 *@Author：ZC
 *@Time： 2019/2/22 14:15
 *@Description：RecyclerView进入时展示的动画
 **/

class RecyclerViewEntryActivity:BaseActivity(){
    private lateinit var rvContent: RecyclerView
    private lateinit var adapter: HeadViewAdapter<String>

    override fun getLayoutId(): Int = R.layout.activity_only_recyclerview

    override fun initView() {
        rvContent = findViewById(R.id.rv_content)
    }

    override fun init() {
    }

    override fun initRv() {
        val list = ArrayList<String>()
        for (i in 1..100){
            list.add(i.toString())
        }
        initAnim()
        adapter = HeadViewAdapter(arrayListOf(View(this)),arrayListOf(View(this))
                ,list)
        rvContent.adapter = adapter
        rvContent.layoutManager = LinearLayoutManager(this)
    }

    /**
     * 初始化列表展示动画
     */
    fun initAnim(){
        val animation = AnimationUtils.loadLayoutAnimation(this,R.anim.layout_animation_fall_down)
        rvContent.layoutAnimation = animation
    }

    override fun initToolsbar() {
        title = "RecyclerView进入时动画展示"
    }
}