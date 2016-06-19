package com.jkgeekjack.mymd;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by @vitovalov on 30/9/15.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    List<String> mListData;

    public ListAdapter(List<String> mListData) {
        this.mListData = mListData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view;
        if (viewType==0){
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_top,
                    viewGroup, false);
        }else {
             view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,
                    viewGroup, false);
        }


        return new MyViewHolder(view,viewType);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int viewType) {
        if (viewType!=0){
            myViewHolder.title.setText(mListData.get(viewType-1));
        }else {
            myViewHolder.tvFoucusedNum.setText("100");
            myViewHolder.tvFocusNum.setText("200");
        }

    }

    //item数量是List的Size+1
    @Override
    public int getItemCount() {
        return mListData == null ? 0 : mListData.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView tvFocusNum;
        TextView tvFoucusedNum;
        public MyViewHolder(View itemView,int i) {
            super(itemView);
            if (i==0){
                tvFocusNum= (TextView) itemView.findViewById(R.id.tvFocusNum);
                tvFoucusedNum= (TextView) itemView.findViewById(R.id.tvFocusedNum);
            }else {
                title = (TextView) itemView.findViewById(R.id.listitem_name);
            }

        }
    }

}

