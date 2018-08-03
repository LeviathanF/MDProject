package com.example.msi_.mdproject.viewholder

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.msi_.mdproject.R

/**
 *@Author：ZC
 *@Time： 2018/8/3 15:20
 *@Description：RecyclerView头部ViewHolder
 **/

class HeadViewHolder:RecyclerView.ViewHolder{

    constructor(root:ViewGroup):super(LayoutInflater.from(root.context)
            .inflate(R.layout.vh_head,root,false))

}