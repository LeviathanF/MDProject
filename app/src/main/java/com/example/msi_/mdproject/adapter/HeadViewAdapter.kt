package com.example.msi_.mdproject.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.example.msi_.mdproject.viewholder.BaseViewHolder
import com.example.msi_.mdproject.viewholder.FooterViewHolder
import com.example.msi_.mdproject.viewholder.HeadViewHolder
import com.example.msi_.mdproject.viewholder.SingleButtonHolder

/**
 *@Author：ZC
 *@Time： 2018/7/25 15:32
 *@Description：带头尾的RecyclerView适配器
 **/
class HeadViewAdapter<T>(mHeaderViewList: ArrayList<View>? = null,
                         mFooterViewList: ArrayList<View>? = null,
                         private val list: List<T>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val mHeaderViewList:ArrayList<View>
    private val mFooterViewList:ArrayList<View>
    private val HEADER = 1
    private val CONTENT = 2
    private val FOOTER = 3

    init {
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

    override fun onCreateViewHolder(root: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){
            HEADER -> {
                return HeadViewHolder(root)
            }
            FOOTER -> {
                return FooterViewHolder(root)
            }
        }
        val creator = SingleButtonHolder::class.java.getField("HOLDER_CREATOR").get(null) as BaseViewHolder.ViewHolderCreator<*>
        return creator.createByViewGroupAndType(root,0)
    }

    override fun getItemCount(): Int {
        return mHeaderViewList.size+list.size+mFooterViewList.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position)==CONTENT){
            (viewHolder as BaseViewHolder<T>).bindData(list[position-mHeaderViewList.size],position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        when (position) {
            in 0..(mHeaderViewList.size-1) ->
                return HEADER
            in (mHeaderViewList.size + list.size)..(itemCount-1) -> return FOOTER
            else -> return CONTENT
        }
    }
}