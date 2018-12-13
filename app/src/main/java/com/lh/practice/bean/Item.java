package com.lh.practice.bean;

import java.util.ArrayList;

/**
 * Created by lh on 2018/10/26.
 */

public class Item {
    public String title;
    public  ArrayList childs;

        public Item(String title, ArrayList childs) {
            this.title = title;
            this.childs = childs;
        }
}
