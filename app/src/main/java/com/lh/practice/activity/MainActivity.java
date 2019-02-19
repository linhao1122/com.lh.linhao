package com.lh.practice.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.lh.practice.R;
import com.lh.practice.bean.Business;
import com.lh.practice.bean.Item;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    public TextView mainTitile;
    public RecyclerView recyclerView;
    public MainAdapter mainAdapter;
    private List<Item> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }
    private void initView() {
        mainTitile=findViewById(R.id.title_main);
        recyclerView = findViewById(R.id.recycleListView_main);
        ////设置布局管理器
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mainAdapter= new  MainAdapter();
        recyclerView.setAdapter(mainAdapter);
        setTitle("首页");
    }
    private void initData() {
        items=new ArrayList<Item>();
        ArrayList arr1 = new ArrayList();
        arr1.add(Business.BASICS);
        arr1.add(Business.CONTROL);
        arr1.add(Business.NEW_TECHNIQUE);
        arr1.add(Business.OTHER);
        ArrayList arr2 = new ArrayList();
        arr2.add(Business.BASICS);
        arr2.add(Business.CONTROL);
//        arr2.add(Business.NEW_TECHNIQUE);
//        arr2.add(Business.OTHER);
        ArrayList arr3 = new ArrayList();
        arr3.add(Business.BASICS);
        arr3.add(Business.CONTROL);
        arr3.add(Business.NEW_TECHNIQUE);
        arr3.add(Business.OTHER);
        items.add(new Item("第一项", arr1));
        items.add(new Item("第二项", arr2));
       // items.add(new Item("第三项", arr3));

        mainAdapter.setData(items);

    }
    public class  MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{
        private List<Item> mList;
        public  MainAdapter(){

        }
        public void setData(List<Item> list){
            this.mList=list;
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.main_item,parent,false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Item item = mList.get(position);
            if (position == 0) {
                holder.title.setText(item.title);
            } else if (position == 1) {
                holder.title.setText(item.title);

            } else if (position == 2) {
                holder.title.setText(item.title);

            }
            holder.grid.setAdapter(new GridAdapter(item.childs));

        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            public TextView title;
            public GridView grid;
            public ViewHolder(View view) {
                super(view);
                title=view.findViewById(R.id.main_item_title);
                grid=view.findViewById(R.id.main_item_grid);
            }
        }

    }
    public class GridAdapter extends BaseAdapter{
        ArrayList  its;
        ImageView icon;
        TextView text;
        int id;
        public GridAdapter(ArrayList  items){
            this.its=items;
        }
        @Override
        public int getCount() {
            return its.size();
        }

        @Override
        public Object getItem(int position) {
            return its.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.main_grid_item,null);
            }
            icon = convertView.findViewById(R.id.grid_icon);
            text = convertView.findViewById(R.id.grid_text);

            id = (int) its.get(position);
            text.setText(Business.getName(id));
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClick(id);
                }
            });

            return convertView;
        }
    }

    public void onItemClick(int business){

        Intent intent=new Intent(this,FirstClassActivity.class);
        intent.putExtra("id",business);
        startActivity(intent);
    }
}
