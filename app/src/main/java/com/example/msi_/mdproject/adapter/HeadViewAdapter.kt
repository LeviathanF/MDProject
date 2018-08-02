package com.example.msi_.mdproject.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

/**
 *@Author：ZC
 *@Time： 2018/7/25 15:32
 *@Description：
 **/
class HeadViewAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private var mHeaderViewList:ArrayList<View>
    private var mFooterViewList:ArrayList<View>
    private var mAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>
    private val HEADER = 0
    private val CONTENT = 1
    private val FOOTER = 2

    constructor(mHeaderViewList:ArrayList<View>?,mFooterViewList:ArrayList<View>?
                ,mAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>):super(){
        this.mAdapter = mAdapter
        if (mHeaderViewList == null){
            this.mHeaderViewList = ArrayList()
        }else{
            this.mHeaderViewList = mHeaderViewList
        }
        if (mFooterViewList == null){
            this.mFooterViewList = ArrayList()
        }else{
            this.mFooterViewList = mFooterViewList
        }
    }

    override fun onCreateViewHolder(root: ViewGroup, position: Int): RecyclerView.ViewHolder {
        when(getItemViewType(position)){
        }
        return this.mAdapter.onCreateViewHolder(root,position-mHeaderViewList.size)
    }

    override fun getItemCount(): Int {
        return mHeaderViewList.size+mAdapter.itemCount+mFooterViewList.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position)==CONTENT){
            mAdapter.bindViewHolder(viewHolder,position-mHeaderViewList.size)
        }
    }

    override fun getItemViewType(position: Int): Int {
        when (position) {
            in 0..mHeaderViewList.size -> return HEADER
            in (mHeaderViewList.size + mAdapter.itemCount)..itemCount -> return FOOTER
            in mHeaderViewList.size..mAdapter.itemCount -> return CONTENT
        }
        return super.getItemViewType(position)
    }
}