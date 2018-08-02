package com.example.msi_.mdproject.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.msi_.mdproject.R;
import com.example.msi_.mdproject.event.VhClickEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * @Author：ZC
 * @Time： 2018/7/19 10:36
 * @Description：只有一个TextView的ViewHolder
 **/
public class SingleButtonHolder extends BaseViewHolder<String> {

    private TextView tvContent;

    @SuppressWarnings("unused")
    public static BaseViewHolder.ViewHolderCreator HOLDER_CREATOR = new ViewHolderCreator(){
        @Override
        public SingleButtonHolder createByViewGroupAndType(ViewGroup group, int type) {
            return new SingleButtonHolder(group);
        }
    };

    private SingleButtonHolder(ViewGroup root) {
        super(root.getContext(), root, R.layout.vh_button);
    }

    @Override
    protected void initView() {
        tvContent = itemView.findViewById(R.id.tv_content);
    }

    @Override
    public void bindData(String s, int position) {
        tvContent.setText(s);
        tvContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new VhClickEvent<>(tvContent));
            }
        });
    }
}
