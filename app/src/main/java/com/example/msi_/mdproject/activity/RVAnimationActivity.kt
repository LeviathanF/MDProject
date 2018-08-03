package com.example.msi_.mdproject.activity

import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import com.example.msi_.mdproject.BaseActivity.BaseActivity
import com.example.msi_.mdproject.R
import com.example.msi_.mdproject.adapter.HeadViewAdapter
import com.example.msi_.mdproject.adapter.OnlyOneTypeAdapter
import com.example.msi_.mdproject.viewholder.SingleButtonHolder

/**
 *@Author：ZC
 *@Time： 2018/7/25 13:54
 *@Description：RecyclerView动画展示
 **/
class RVAnimationActivity:BaseActivity(){
    private lateinit var rvContent:RecyclerView
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
        adapter = HeadViewAdapter(arrayListOf(View(this)),arrayListOf(View(this))
                ,list)
        rvContent.adapter = adapter
        rvContent.layoutManager = LinearLayoutManager(this)
//        为RecyclerView添加分割线并设置分割线样式
        val decoration = DividerItemDecoration(this,LinearLayout.VERTICAL)
        decoration.setDrawable(getDrawable(R.drawable.rv_line))
        rvContent.addItemDecoration(decoration)

    }

    override fun initToolsbar() {
        title = "RecyclerView动画展示"
    }

}