package com.jkgeekjack.mymd;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/18.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecVH> {
    List<Product> products=new ArrayList<Product>();

    //构造方法传入数据
    public RecyclerAdapter(List<Product>products){
        this.products=products;
    }

    //创造ViewHolder
    @Override
    public RecVH onCreateViewHolder(ViewGroup parent, int viewType) {
        //把item的Layout转化成View传给ViewHolder
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler,parent,false);
        return new RecVH(view);
    }
//    将数据放入相应的位置
    @Override
    public void onBindViewHolder(RecVH holder, int position) {
        holder.tvTitle.setText(products.get(position).getTitle());
        holder.ivPic.setImageResource(products.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    //ViewHolder绑定控件
    public class RecVH extends RecyclerView.ViewHolder{
        ImageView ivPic;
        TextView tvTitle;
        public RecVH(View itemView) {
            super(itemView);
            ivPic= (ImageView) itemView.findViewById(R.id.ivPic);
            tvTitle= (TextView) itemView.findViewById(R.id.tvTitle);
        }
    }
}
