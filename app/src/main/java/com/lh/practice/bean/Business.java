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
                return "1.1 Android开发秘籍";
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
                break;
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
            case BASICS_DEVELOP_SECRET_BOOK:
                list= getDevelopSecretBook();
                break;
            case BASICS_FIRST_LINE_FOR_CODE:
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
        list.add(new Business(BASICS_DEVELOP_SECRET_BOOK,getName(BASICS_DEVELOP_SECRET_BOOK)));
        list.add(new Business(BASICS_FIRST_LINE_FOR_CODE,getName(BASICS_FIRST_LINE_FOR_CODE)));
        return list;
    }

    private static ArrayList<Business> getDevelopSecretBook() {
        list.add(new Business(BASICS_DEVELOP_SECRET_BOOK,getName(BASICS_DEVELOP_SECRET_BOOK)));
        list.add(new Business(BASICS_FIRST_LINE_FOR_CODE,getName(BASICS_FIRST_LINE_FOR_CODE)));

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
