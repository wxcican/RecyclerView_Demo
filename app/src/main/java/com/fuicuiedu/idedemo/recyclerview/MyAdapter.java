package com.fuicuiedu.idedemo.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/11/25 0025.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<String> mData;

    //alt + insert ,constuctor

    public MyAdapter(List<String> mData) {
        this.mData = mData;
    }

    //创建viewholder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_view,parent,false));
        return viewHolder;
    }

    //操作item
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.textView.setText(mData.get(position));


        //点击监听
        if (listener != null){
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(v,position);
                }
            });
            holder.textView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onItemLongClick(v,position);
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;


        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.item_tv);
        }
    }


    private OnItemClickedListener listener;

    //点击监听接口
    public interface OnItemClickedListener{
        //点击触发方法
        void onItemClick(View view,int postion);

        //长摁触发的方法
        void onItemLongClick(View view,int postion);
    }

    //对外提供一个监听的方法
    public void setOnItemClickedListener(OnItemClickedListener listener){
        this.listener = listener;
    }


}
