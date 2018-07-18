package com.example.msi_.mdproject.activity

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.example.msi_.mdproject.R
import com.example.msi_.mdproject.adapter.OnlyOneTypeAdapter
import com.example.msi_.mdproject.bean.Item
import com.example.msi_.mdproject.event.VhClickEvent
import com.example.msi_.mdproject.viewholder.PictureViewHolder
import com.example.msi_.mdproject.viewholder.TestViewHolder
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

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

    private fun lauch(view:View){
        val compat:ActivityOptionsCompat = ActivityOptionsCompat.makeScaleUpAnimation(view,
                view.width/2,view.height/2,0,0)
    }

    @SuppressWarnings("unused")
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onItemClick(event:VhClickEvent<*>){
        if (event.t is ImageView){
            val imageView = event.t as ImageView
            val intent = Intent(this,PictureDetailActivity::class.java)
            val transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this,imageView,"transView")
            startActivity(intent,transitionActivityOptions.toBundle())
        }
    }
}