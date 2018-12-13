package com.lh.practice.bean;

import android.content.Context;
import android.content.Intent;

import com.lh.practice.activity.TestActivity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lh on 2018/4/23.
 */

public class Business implements Serializable{

    public int id;
    public String name;

    //档案
    public static final int ARCHIVE = 0;
    //基础
    public static final int BASICS = 1;
    //控件
    public static final int CONTROL = 2;
    //新技术
    public static final int NEW_TECHNIQUE = 3;
    //OTHER
    public static final int OTHER = 4;
    //第三方控件
    public static final int THIRD_PARTY = 5;
    //工具类
    public static final int UTILS = 6;
    //常用UI控件
    public static final int BASICS_UI = 101;
    public static final int BASICS_Test = 199;

    public static ArrayList<Business> list=new ArrayList<Business>();

    public Business(int i, String name) {
        this.id=i;
        this.name=name;
    }

    public static String getName(int id) {
        switch (id) {
            case ARCHIVE:
                return "档案";
            case BASICS:
                return "基础";
            case CONTROL:
                return "控件";
            case NEW_TECHNIQUE:
                return "新技术";
            case OTHER:
                return "其他";
            case THIRD_PARTY:
                return "第三方控件";
            case UTILS:
                return "工具类";
        }
        return "";
    }
    public static ArrayList<Business> getData(int id){
        switch (id) {
            case ARCHIVE:
                list= getArchiveData();
                break;
            case BASICS:
                list= getBasicsData();
                break;
            case CONTROL:
                list= getControlData();
                break;
            case OTHER:
                list= getOtherlData();
                break;
            case NEW_TECHNIQUE:
                list= getTechnueData();
                break;
            case THIRD_PARTY:
                list= getTechnueData();
                break;
            case UTILS:
                list= getUtilsData();
                break;
        }
        return list;
    }

    private static ArrayList<Business> getTechnueData() {

        list.add(new Business(111,"信息"));
        return list;
    }

    private static ArrayList<Business> getOtherlData() {

        list.add(new Business(121,"信息"));

        return list;
    }

    private static ArrayList<Business> getControlData() {

        list.add(new Business(111,"信息"));
        return list;
    }

    private static ArrayList<Business> getBasicsData() {

        list.add(new Business(BASICS_UI,"常用UI控件"));
        list.add(new Business(102,"事件处理机制"));
        list.add(new Business(103,"四大组件和Intent"));
        list.add(new Business(104,"Fragment"));
        list.add(new Business(BASICS_Test,"Test"));
        return list;
    }

    public static ArrayList<Business> getArchiveData() {

        list.add(new Business(111,"信息"));
        return list;
    }

    public static ArrayList<Business> getUtilsData() {

        list.add(new Business(111,"信息"));
        return list;
    }

    public static void onItemClick(Context mContext, int id) {
        Intent intent =new Intent();
        switch (id) {
            case BASICS_Test:
                intent.setClass(mContext, TestActivity.class);
                intent.putExtra("id",id);
                break;
        }
        mContext.startActivity(intent);
    }

}
