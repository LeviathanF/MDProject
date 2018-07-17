package com.example.msi_.mdproject.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.msi_.mdproject.R
import com.example.msi_.mdproject.adapter.OnlyOneTypeAdapter
import com.example.msi_.mdproject.bean.Item
import com.example.msi_.mdproject.viewholder.PictureViewHolder
import com.example.msi_.mdproject.viewholder.TestViewHolder

/**
 *@Author：ZC
 *@Time： 2018/7/13 14:56
 *@Description：
 **/
class ListMDshow: AppCompatActivity() {
    private lateinit var rvContent:RecyclerView
    private lateinit var adapter:OnlyOneTypeAdapter<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listmdshow)
        initView()
        initToolsbar()
        initRv()
    }

    private fun initView(){
        rvContent = findViewById(R.id.rv_content)
    }

    private fun initRv(){
        adapter = OnlyOneTypeAdapter(TestViewHolder::class.java)
        var list = ArrayList<Item>()
        for (i in 1..10){
            list.add(Item(i.toString()))
        }
        adapter.setList(list)
        rvContent.layoutManager = GridLayoutManager(this,3)
        rvContent.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun initToolsbar(){
        title = "列表"
//        if (supportActionBar!=null) {
//            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
//            supportActionBar!!.setHomeButtonEnabled(true)
//        }
    }
}