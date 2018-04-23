package com.lh.practice.bean;

/**
 * Created by lh on 2018/4/23.
 */

public class Business {
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

    public static String getName(int id) {
        switch (id) {
            case ARCHIVE:
                return "档案";
            case BASICS:
                return "基础";
            case CONTROL:
                return "控件";
            case OTHER:
                return "其他";
            case NEW_TECHNIQUE:
                return "新技术";
        }
        return "";
    }
}
