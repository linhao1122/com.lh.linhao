package com.lh.practice.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lh on 2018/4/23.
 */

public class BusinessChild implements Serializable{
    public int id;

    public static final int BASICS_UI = 100;
    public static final int BASICS_DB = 200;
    public static final int BASICS_INTENT = 300;

    public static String getName(int id) {
        switch (id) {
            case BASICS_UI:
                return "档案";
            case BASICS_DB:
                return "基础";
            case BASICS_INTENT:
                return "控件";

        }
        return "";
    }
    public static ArrayList<String> getData(int id){
        switch (id) {
            case BASICS_UI:
                getArchiveData();
                break;
            case BASICS_DB:
                getBasicsData();
                break;
            case BASICS_INTENT:
                getControlData();
                break;
        }

        return null;
    }

    private static ArrayList<String> getTechnueData() {
        ArrayList<String> list=new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        return list;
    }

    private static ArrayList<String> getOtherlData() {
        ArrayList<String> list=new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        return list;
    }

    private static ArrayList<String> getControlData() {
        ArrayList<String> list=new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        return list;
    }

    private static ArrayList<String> getBasicsData() {
        ArrayList<String> list=new ArrayList<>();
        list.add("常用UI控件");
        list.add("事件处理机制");
        list.add("四大组件和Intent");
        list.add("Fragment");
        list.add("数据存储");
        list.add("网络编程");
        list.add("绘图和动画");
        list.add("多媒体开发");
        list.add("地图定位");
        return list;
    }

    public static ArrayList<String> getArchiveData() {
        ArrayList<String> list=new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        return list;
    }

}
