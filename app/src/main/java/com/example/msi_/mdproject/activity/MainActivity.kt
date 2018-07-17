package com.example.msi_.mdproject.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.msi_.mdproject.R

class MainActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var btn1:Button
    private lateinit var btn2:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        init()
    }

    private fun initView(){
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
    }

    private fun init(){
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        var intent:Intent? = null
        when(view.id){
            R.id.btn1 -> {intent = Intent(this, ListMDshow::class.java)}
            R.id.btn2 -> {intent = Intent(this,AnimationActivity::class.java)}
            else -> {}
        }
        if (intent != null){
            startActivity(intent)
        }
    }
}
