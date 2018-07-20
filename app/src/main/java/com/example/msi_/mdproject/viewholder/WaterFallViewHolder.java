package com.example.msi_.mdproject.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.msi_.mdproject.R;

/**
 * @Author：ZC
 * @Time： 2018/7/20 11:34
 * @Description：瀑布流展示ViewHolder
 **/
public class WaterFallViewHolder extends BaseViewHolder<String> {

    private int[] colors = {Color.BLUE,Color.RED,Color.GREEN,Color.MAGENTA};
    private LinearLayout llContent;

    public static BaseViewHolder.ViewHolderCreator HOLDER_CREATOR = new ViewHolderCreator() {
        @Override
        public WaterFallViewHolder createByViewGroupAndType(ViewGroup group, int type) {
            return new WaterFallViewHolder(group);
        }
    };

    private WaterFallViewHolder(ViewGroup root) {
        super(root.getContext(), root, R.layout.vh_waterfall);
    }

    @Override
    protected void initView() {
        llContent = itemView.findViewById(R.id.ll_content);
        ViewGroup.LayoutParams params = llContent.getLayoutParams();
//        随机分配组件高度
        params.height = (int)(Math.random()*200+200);
        llContent.setLayoutParams(params);
    }

    @Override
    public void bindData(String s, int position) {
        llContent.setBackgroundColor(colors[position%colors.length]);
    }
}
