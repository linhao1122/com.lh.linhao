package com.lh.practice.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lh.practice.Interface.FoundationClickListener;
import com.lh.practice.R;
import com.lh.practice.adapter.FoundationAdapter;
import com.lh.practice.bean.Business;

import java.util.ArrayList;

public class TwoLevelMenuActivity extends AppCompatActivity {
    public ArrayList<Business> list;
    public RecyclerView recyclerView;
    public FoundationAdapter adapter;
    public int id;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acrivity_foundation);
        initParams(savedInstanceState);
        initView();
        initData();
    }
    private void initParams(Bundle savedInstanceState) {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 1);

    }
    private void initView() {
        recyclerView=findViewById(R.id.foundation_recycler);
        LinearLayoutManager layoutManager=new LinearLayoutManager(TwoLevelMenuActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new FoundationAdapter();
        list=new ArrayList<Business>();
    }
    private void initData() {

        list = Business.getData(id);
        adapter.setData(this,list);
        recyclerView.setAdapter(adapter);
        setTitle(Business.getName(id));
        adapter.setFoundationClickListener(new FoundationClickListener() {
            @Override
            public void FoundationItemClick(Context mContext, int id) {
                goToNext(mContext,id);
            }
        });
    }

    private void goToNext(Context mContext, int id) {
        Intent intent =new Intent();
        switch (id) {
            case Business.BASICS_TEST: {
                intent.setClass(mContext, TestActivity.class);
                intent.putExtra("id", this.id);
            }
            break;
            default:
                intent.setClass(mContext, TwoLevelMenuActivity.class);
                intent.putExtra("id", this.id);
                break;
        }
        mContext.startActivity(intent);

    }




}
