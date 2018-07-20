package com.example.msi_.mdproject.activity

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.widget.LinearLayout
import com.example.msi_.mdproject.BaseActivity.BaseActivity
import com.example.msi_.mdproject.adapter.OnlyOneTypeAdapter
import com.example.msi_.mdproject.R
import com.example.msi_.mdproject.viewholder.WaterFallViewHolder

/**
 *@Author：ZC
 *@Time： 2018/7/20 11:21
 *@Description：瀑布流RecyclerView展示
 **/
class WaterFallActivity:BaseActivity(){
    private lateinit var rvContent:RecyclerView
    private lateinit var adapter:OnlyOneTypeAdapter<String>

    override fun getLayoutId(): Int = R.layout.activity_only_recyclerview

    override fun initView() {
        rvContent = findViewById(R.id.rv_content)
    }

    override fun init() {
    }

    override fun initToolsbar() {
        title="瀑布流展示"
    }

    override fun initRv() {
        val list = ArrayList<String>()
        for (i in 1..100){
            list.add(i.toString())
        }
        adapter = OnlyOneTypeAdapter(WaterFallViewHolder::class.java)
        adapter.setList(list)
        rvContent.layoutManager = StaggeredGridLayoutManager(3,LinearLayout.VERTICAL)
        rvContent.adapter = adapter
    }

}