package com.lh.practice.adapter;

import android.content.Context;
import android.content.IntentFilter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lh.practice.Interface.FoundationClickListener;
import com.lh.practice.R;
import com.lh.practice.bean.Business;
import com.lh.practice.bean.BusinessChild;

import java.net.IDN;
import java.util.ArrayList;

/**
 * Created by lh on 2018/4/24.
 *
 */

public class FoundationAdapter extends RecyclerView.Adapter<FoundationAdapter.ViewHolder>{

    public ArrayList<Business> list=new ArrayList<>();
    public Context mContext;
    FoundationClickListener foundationClickListener;

    public  FoundationAdapter(Context context, ArrayList<Business> arrayList){
        this.mContext=context;
        this.list=arrayList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.acrivity_foundation_item,parent, false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Business business = list.get(position);
        holder.textView.setText(business.name);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick(mContext,business.id);
            }
        });
    }

    private void onItemClick(Context mContext, int id) {

        foundationClickListener.FoundationItemClick(mContext, id);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView= itemView.findViewById(R.id.foundation_item_text);
        }
    }

    public void setFoundationClickListener(FoundationClickListener listener){
        this.foundationClickListener=listener;
    }
}
