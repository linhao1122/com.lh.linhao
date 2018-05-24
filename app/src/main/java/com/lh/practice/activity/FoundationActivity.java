package com.lh.practice.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lh.practice.R;
import com.lh.practice.adapter.FoundationAdapter;
import com.lh.practice.bean.Business;

import java.net.IDN;
import java.util.ArrayList;

/**
 * Created by lh on 2018/4/24.
 * 基础列表
 */

public class FoundationActivity extends AppCompatActivity{
    public ArrayList<String> list;
    public RecyclerView recyclerView;
    public FoundationAdapter adapter;
    public int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acrivity_foundation);
        initParams(savedInstanceState);
        initView();
        initData();
    }

    public void initParams(Bundle bundle) {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 1);
    }

    public void initData() {
        list.addAll(Business.getData(id));
        adapter=new FoundationAdapter(this,list);
        recyclerView.setAdapter(adapter);
        setTitle(Business.getName(id));
    }

    public void initView() {

        recyclerView=findViewById(R.id.foundation_recycler);
        LinearLayoutManager layoutManager=new LinearLayoutManager(FoundationActivity.this);
        recyclerView.setLayoutManager(layoutManager);
    }
}
