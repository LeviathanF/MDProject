package com.example.msi_.mdproject.activity

import android.app.ActivityOptions
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.msi_.mdproject.R

/**
 *@Author：ZC
 *@Time： 2018/7/17 15:58
 *@Description：主页面
 **/
class MainActivity : AppCompatActivity(),View.OnClickListener {

//    跳转图片RecyclerView动画页面
    private lateinit var btn1:Button
//    跳转渐变动画页面
    private lateinit var btn2:Button
//    跳转Activity展开页面
    private lateinit var btn3:Button
//    RecyclerView点击项目展示页面
    private lateinit var btn4:Button
//    RecyclerView瀑布流展示页面
    private lateinit var btn5:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        init()
    }

    private fun initView(){
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
    }

    private fun init(){
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        var intent:Intent? = null
        when(view.id){
            R.id.btn1 -> {intent = Intent(this, ListMDshow::class.java)}
            R.id.btn2 -> { intent = Intent(this,AnimationActivity::class.java) }
            R.id.btn3 -> {
                intent = Intent(this,ShowActivity::class.java)
                startActivity(intent,
                        ActivityOptions.makeClipRevealAnimation(view,0,0,view.width,view.height).toBundle())
                return
            }
            R.id.btn4 -> { intent = Intent(this,VerticalListActivity::class.java) }
            R.id.btn5 -> { intent = Intent(this,WaterFallActivity::class.java) }
            else -> {}
        }
        if (intent != null){
            startActivity(intent)
        }
    }
}
