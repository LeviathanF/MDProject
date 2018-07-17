package com.example.msi_.mdproject.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.msi_.mdproject.bean.Item
import com.example.msi_.mdproject.R

/**
 *@Author：ZC
 *@Time： 2018/7/17 11:19
 *@Description：
 **/
class PictureViewHolder(root:ViewGroup): BaseViewHolder<Item>(root.context,root,R.layout.vh_rp) {
    private lateinit var ivContent:ImageView
    private lateinit var tvTitle:TextView

    companion object {
        var HOLDER_CREATOR =
                BaseViewHolder.ViewHolderCreator<PictureViewHolder>{group, type -> PictureViewHolder(group)}
    }
    override fun initView() {
        ivContent = itemView.findViewById(R.id.iv_content)
        tvTitle = itemView.findViewById(R.id.tv_title)
    }

    override fun bindData(bean: Item, position: Int) {
        tvTitle.setText(bean.title)
        if (bean.icoId==0){
            ivContent.setImageResource(R.mipmap.ic_launcher_round)
        }else{
            ivContent.setImageResource(bean.icoId)
        }
    }

}