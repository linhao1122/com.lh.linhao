package com.lh.practice.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.lh.practice.R;
import com.lh.practice.until.ParseUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lh on 2018/10/29.
 */

public class TestActivity extends AppCompatActivity {
    public TextView text;
    public Map<String, Object> mValueMap = new HashMap<>();
    public Map<String, Object> map = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();
        initData();
    }

    private void initView() {
        text = findViewById(R.id.text);
    }
    private void initData() {

        String str="{\"bczysfhdbz\":\"\",\"ygdyw\":[{\"jl\":\"6\",\"ffcs\":\"3\",\"ypid\":\"222\",\"fyff\":\"3\",\"ypmc\":\"美降之\",\"ywlx\":\"8\"}],\"yldy\":\"3\",\"ywblfyxs\":\"\",\"ywwhxw\":\"\",\"ywyzblfy\":\"0\",\"ywzl\":[],\"ywzz\":\"\",\"yyjl\":[],\"zaohuocs\":\"\",\"zaoshics\":\"\",\"zc\":\"\",\"zdgzjb\":\"\",\"zfbz\":\"0\",\"zh\":\"\",\"zjdm\":\"\",\"zjhm\":\"239006196509166406\",\"zjyczlxg\":\"2\",\"zkysjy\":\"\",\"zlcj\":\"\",\"zqty\":\"1\",\"zrxhjhx\":\"1\",\"zrys\":\"165\",\"zs\":\"\",\"zscs\":\"\",\"zswscs\":\"\",\"zxgzjb\":\"\",\"zydm\":\"2\",\"zyhgz\":\"1\",\"zzyx\":\"\"}";
        mValueMap= ParseUtil.getMap(str);
        map.put("xm","林浩");
        map.put("xb","男");
        map.put("sr","1989-11-22");
        map.put("tz","61");
        map.put("sg","175");
        map.put("qt","[]");
       // mValueMap.put("yyjl","[{\"jl\":\"6\",\"ffcs\":\"3\",\"ypid\":\"222\",\"fyff\":\"3\",\"ypmc\":\"美降之\",\"ywlx\":\"8\"}]");
        com.alibaba.fastjson.JSONArray arr = new com.alibaba.fastjson.JSONArray();
        com.alibaba.fastjson.JSONArray array=null;
        for (Map.Entry<String, Object> entry : mValueMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if(value instanceof ArrayList){
                ArrayList list = (ArrayList)value;
                array = com.alibaba.fastjson.JSONArray.parseArray(JSON.toJSONString(list));
                mValueMap.put(key,arr.toString());
            }else if( value.toString().startsWith("[") && value.toString().endsWith("]")) {
                String yyjl = value.toString();
                array=JSON.parseArray(yyjl);
                mValueMap.put(key,array.toString());
            }
        }
        String str1 = ParseUtil.getJsonString(mValueMap);
        String str2 = ParseUtil.getJsonString(map);
        text.setText("str1="+str1+"/t"+"str2="+str2);
    }
}
