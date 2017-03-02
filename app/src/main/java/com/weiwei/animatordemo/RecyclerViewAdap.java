package com.weiwei.animatordemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by wenwei on 2017/3/2.
 */

public class RecyclerViewAdap extends RecyclerView.Adapter<RecyclerViewAdap.ViewHolders> {
    private String[] datas;
    private Context mContext;
    private OnClicksListener listener;

    public RecyclerViewAdap(Context mContext, String[] datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    public void setOnClicksListener(OnClicksListener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return datas.length;
    }

    @Override
    public ViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.items_recyclerview, null);
//        LayoutInflater.from(mContext).inflate(R.layout.items_recyclerview,parent,false);
        return new ViewHolders(view);
    }

    @Override
    public void onBindViewHolder(ViewHolders holder, final int position) {
        holder.setText(datas[position]);
        holder.tvContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClickListener(datas[position]);
                }
            }
        });
    }

    static class ViewHolders extends RecyclerView.ViewHolder {
        public TextView tvContent;

        public ViewHolders(View itemView) {
            super(itemView);
            tvContent =(TextView) itemView;
        }

        public ViewHolders setText(String text) {

            tvContent.setText(text);
            return this;
        }
    }

    interface OnClicksListener {
        void onClickListener(String content);
    }
}
