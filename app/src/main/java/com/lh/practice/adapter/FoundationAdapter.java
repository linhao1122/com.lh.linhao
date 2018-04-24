package com.lh.practice.adapter;

import android.content.Context;
import android.content.IntentFilter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lh.practice.R;

import java.util.ArrayList;

/**
 * Created by lh on 2018/4/24.
 *
 */

public class FoundationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public ArrayList<String> list;
    public Context mContext;
    public void FoundationAdapter(Context context, ArrayList<String> arrayList){
        this.mContext=context;
        this.list=arrayList;
        notifyDataSetChanged();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.acrivity_foundation_item, null);
        return view;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        String s = list.get(position);
        viewHolder.textView.setText(s);
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

}
