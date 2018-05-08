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

import java.util.ArrayList;

/**
 * Created by lh on 2018/4/24.
 * 基础列表
 */

public class FoundationActivity extends AppCompatActivity{
    public ArrayList list;
    public RecyclerView recyclerView;
    public FoundationAdapter adapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.acrivity_foundation);
        if (savedInstanceState != null) {
            initParams(savedInstanceState);
        }
        initView();
        initData();
    }

    public void initParams(Bundle bundle) {

    }

    public void initData() {

        recyclerView.setAdapter(adapter);
    }

    public void initView() {
        recyclerView=findViewById(R.id.foundation_recycler);
        LinearLayoutManager layoutManager=new LinearLayoutManager(FoundationActivity.this);
        recyclerView.setLayoutManager(layoutManager);
    }
}
