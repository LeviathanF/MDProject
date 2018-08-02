package com.example.msi_.mdproject.activity

import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewStub
import com.example.msi_.mdproject.BaseActivity.BaseActivity
import com.example.msi_.mdproject.R
import com.example.msi_.mdproject.adapter.OnlyOneTypeAdapter
import com.example.msi_.mdproject.event.VhClickEvent
import com.example.msi_.mdproject.viewholder.DelleteViewHolder
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 *@Author：ZC
 *@Time： 2018/7/20 16:55
 *@Description： RecyclerView删除Item
 **/
class RecyclerViewShowActivity:BaseActivity(){
    private lateinit var rvContent:RecyclerView
    private lateinit var adapter: OnlyOneTypeAdapter<String>
    private lateinit var vsFab:ViewStub
    private lateinit var fabReduce:FloatingActionButton

    override fun getLayoutId() = R.layout.activity_only_recyclerview

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    override fun initView() {
        rvContent = findViewById(R.id.rv_content)
        vsFab = findViewById(R.id.vs_fab)
    }

    override fun init() {
        fabReduce = vsFab.inflate().findViewById(R.id.fab_reduce) as FloatingActionButton
        fabReduce.setOnClickListener {
            adapter.addItem(1,"test")
        }
    }

    override fun initToolsbar() {
        title = " RecyclerView删除Item"
    }

    override fun initRv() {
        val list = ArrayList<String>()
        for (i in 1..100){
            list.add(i.toString())
        }
        adapter = OnlyOneTypeAdapter(DelleteViewHolder::class.java)
        adapter.setList(list)
        rvContent.adapter = adapter
        rvContent.layoutManager = LinearLayoutManager(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    @SuppressWarnings("unused")
    fun onRVItemClick(event: VhClickEvent<Int>){
        event.t?.let { adapter.removeItem(it) }
    }
}