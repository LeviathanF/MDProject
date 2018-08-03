package com.example.msi_.mdproject.activity

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import com.example.msi_.mdproject.R
import com.example.msi_.mdproject.adapter.OnlyOneTypeAdapter
import com.example.msi_.mdproject.event.VhClickEvent
import com.example.msi_.mdproject.viewholder.SingleButtonHolder
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 *@Author：ZC
 *@Time： 2018/7/19 10:28
 *@Description：垂直list跳转展示动画
 **/
class  VerticalListActivity:AppCompatActivity(){
    private lateinit var rvContent:RecyclerView
    private lateinit var adapter: OnlyOneTypeAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_only_recyclerview)
        initView()
        init()
        initRecvclerView()
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    private fun initView(){
        rvContent = findViewById(R.id.rv_content)
    }

    private fun init(){
        title = "列表转场动画"
    }

    private fun initRecvclerView(){
        val list = ArrayList<String>()
        for (i in 1..10){
            list.add(i.toString())
        }
        adapter  = OnlyOneTypeAdapter(SingleButtonHolder::class.java)
        adapter.setList(list)
        rvContent.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        rvContent.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    /**
     * RecyclerView项目点击事件
     * event中存储的view被指定activity跳转动画的动画view
     */
    @SuppressWarnings("unused")
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onItemClike(event: VhClickEvent<TextView>){
        if (event.t is TextView){
            val view = event.t
            view?.let{
                val intent = Intent(this, PictureDetailActivity::class.java)
                startActivity(intent, ActivityOptionsCompat.makeClipRevealAnimation(it, 0, 0, it.width, it.height).toBundle())
            }
        }
    }
}