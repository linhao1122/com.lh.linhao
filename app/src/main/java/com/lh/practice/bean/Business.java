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
    //基础-安浪开发秘籍
    public static final int BASICS_DEVELOP_SECRET_BOOK = 101;
    //安浪开发-简单控件与布局 2
    public static final int DEVELOP_SECRET_UI = 101100;
    // 2.1 View与ViewGroup的概念
    public static final int DEVELOP_SECRET_VIEW_AND_VIEWGROUP = 101101;
    // 2.2 线性布局 LinearLayout
    public static final int DEVELOP_SECRET_LINEARLAYOUT = 101102;
    // 2.3 相对布局 RelativeLayout
    public static final int DEVELOP_SECRET_RALATIVELAYOUT = 101103;
    // 2.4 表格布局 TableLayout
    public static final int DEVELOP_SECRET_TABLELAYOUT = 101104;
    // 2.5 帧布局 FrameLayout
    public static final int DEVELOP_SECRET_FRAMELAYOUT = 101105;
    // 2.6 网格布局 GridLayout
    public static final int DEVELOP_SECRET_GRIDLAYOUT = 101106;


    //安浪开发-回调与点击事件
    public static final int DEVELOP_SECRET_ONCLICK = 101200;
    //安浪开发- 四大组件与intent
    public static final int DEVELOP_SECRET_INTENTS = 101300;
    //安浪开发- 四大组件与Fragment
    public static final int DEVELOP_SECRET_FRAGMENT = 101400;

    //基础-第一行代码（第二版）
    public static final int BASICS_FIRST_LINE_FOR_CODE = 102;

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
    public static final int BASICS_UI = 7;
    public static final int BASICS_TEST = 10000;

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
            case BASICS_DEVELOP_SECRET_BOOK:
                return "1.1 Android安浪开发秘籍";
            case BASICS_FIRST_LINE_FOR_CODE:
                return "1.2 第一行代码（第二版）";
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
            default:
                return getTwolevelData(id);
        }
    }

    public static String  getTwolevelData(int id) {

        switch (id) {
            // Android安浪开发秘籍
            case DEVELOP_SECRET_UI:
                return "1.1 安浪开发-简单控件与布局";
            case DEVELOP_SECRET_ONCLICK:
                return "1.2 安浪开发-回调与点击事件";
            case DEVELOP_SECRET_INTENTS:
                return "1.3 安浪开发-四大组件与intent";
            case DEVELOP_SECRET_FRAGMENT:
                return "1.4 安浪开发-Fragment";



            default:
               return getLasetData(id);
        }
    }

    private static String getLasetData(int id) {
        switch (id) {
            //1.1 安浪开发-简单控件与布局
            case DEVELOP_SECRET_VIEW_AND_VIEWGROUP:
                return "2.1 View与ViewGroup的概念";
            case DEVELOP_SECRET_LINEARLAYOUT:
                return "2.2 线性布局 LinearLayout";
            case DEVELOP_SECRET_RALATIVELAYOUT:
                return "2.3 相对布局 RelativeLayout";
            case DEVELOP_SECRET_TABLELAYOUT:
                return "2.4 表格布局 TableLayout";
            case DEVELOP_SECRET_FRAMELAYOUT:
                return "2.5 帧布局 FrameLayout";
            case DEVELOP_SECRET_GRIDLAYOUT:
                return "2.6 网格布局 GridLayout";

            default:
                break;
        }
        return "暂无";
    }

    public static ArrayList<Business> getData(int id){
        switch (id) {
            case ARCHIVE:
                list= getArchiveData();
                break;
            case BASICS:
                list= getBasicsData();
                break;
            case BASICS_DEVELOP_SECRET_BOOK:
                list= getDevelopSecretBook();
                break;
            case DEVELOP_SECRET_UI:
                list= getDevelopSecretUi();
                break;
            case BASICS_FIRST_LINE_FOR_CODE:
                list= getFristLineForCode();
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
        list.add(new Business(BASICS_DEVELOP_SECRET_BOOK,getName(BASICS_DEVELOP_SECRET_BOOK)));
        list.add(new Business(BASICS_FIRST_LINE_FOR_CODE,getName(BASICS_FIRST_LINE_FOR_CODE)));
        return list;
    }

    private static ArrayList<Business> getDevelopSecretBook() {

        list.add(new Business(DEVELOP_SECRET_UI,getName(DEVELOP_SECRET_UI)));
        list.add(new Business(DEVELOP_SECRET_ONCLICK,getName(DEVELOP_SECRET_ONCLICK)));
        list.add(new Business(DEVELOP_SECRET_INTENTS,getName(DEVELOP_SECRET_INTENTS)));
        list.add(new Business(DEVELOP_SECRET_FRAGMENT,getName(DEVELOP_SECRET_FRAGMENT)));
//        list.add(new Business(DEVELOP_SECRET_ONCLICK,getName(DEVELOP_SECRET_ONCLICK)));
//        list.add(new Business(DEVELOP_SECRET_ONCLICK,getName(DEVELOP_SECRET_ONCLICK)));

        return list;
    }
    private static ArrayList<Business> getDevelopSecretUi() {
        list.add(new Business(DEVELOP_SECRET_UI,getName(DEVELOP_SECRET_UI)));
        list.add(new Business(DEVELOP_SECRET_ONCLICK,getName(DEVELOP_SECRET_ONCLICK)));
        list.add(new Business(DEVELOP_SECRET_INTENTS,getName(DEVELOP_SECRET_INTENTS)));
        list.add(new Business(DEVELOP_SECRET_FRAGMENT,getName(DEVELOP_SECRET_FRAGMENT)));

        return list;
    }




    private static ArrayList<Business> getFristLineForCode() {
        list.add(new Business(DEVELOP_SECRET_UI,getName(DEVELOP_SECRET_UI)));
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
}
