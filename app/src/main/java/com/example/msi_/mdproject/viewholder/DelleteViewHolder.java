package com.example.msi_.mdproject.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.msi_.mdproject.R;
import com.example.msi_.mdproject.event.VhClickEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * @Author：ZC
 * @Time： 2018/7/21 10:31
 * @Description：
 **/
public class DelleteViewHolder extends BaseViewHolder<String> {
    private Button button;

    @SuppressWarnings("unused")
    public static BaseViewHolder.ViewHolderCreator HOLDER_CREATOR = new ViewHolderCreator() {
        @Override
        public DelleteViewHolder createByViewGroupAndType(ViewGroup group, int type) {
            return new DelleteViewHolder(group);
        }
    };

    private DelleteViewHolder(ViewGroup root) {
        super(root.getContext(), root, R.layout.vh_button);
    }

    @Override
    protected void initView() {
        button = itemView.findViewById(R.id.tv_content);
    }

    @Override
    public void bindData(String s, final int position) {
        button.setText(s);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new VhClickEvent<>(position));
            }
        });
    }
}
