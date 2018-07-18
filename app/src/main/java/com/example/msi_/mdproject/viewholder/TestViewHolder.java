package com.example.msi_.mdproject.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.msi_.mdproject.bean.Item;
import com.example.msi_.mdproject.R;
import com.example.msi_.mdproject.event.VhClickEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * @Author：ZC
 * @Time： 2018/7/17 15:22
 * @Description：
 **/
public class TestViewHolder extends BaseViewHolder<Item> {
    private ImageView ivContent;
    private TextView tvTitle;
    public static BaseViewHolder.ViewHolderCreator HOLDER_CREATOR = new ViewHolderCreator() {
        @Override
        public BaseViewHolder createByViewGroupAndType(ViewGroup group, int type) {
            return new TestViewHolder(group);
        }
    };

    public TestViewHolder(ViewGroup root) {
        super(root.getContext(), root, R.layout.vh_rp);
    }
    @Override
    protected void initView() {
        ivContent = itemView.findViewById(R.id.iv_content);
        tvTitle = itemView.findViewById(R.id.tv_title);
    }

    @Override
    public void bindData(Item bean, int position) {
        tvTitle.setText(bean.getTitle());
        if (bean.getIcoId()==0){
            ivContent.setImageResource(R.mipmap.ic_launcher_round);
        }else{
            ivContent.setImageResource(bean.getIcoId());
        }
        ivContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new VhClickEvent<>(ivContent));
            }
        });
    }
}
