package com.lh.practice.until;

import android.content.ContentValues;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ParseUtil {

    public static JSONArray remove(JSONArray jsonArray, int index) {
        JSONArray array = new JSONArray();
        for (int i = 0; i < jsonArray.length(); i++) {
            if (i != index) {
                try {
                    array.put(jsonArray.get(i));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return array;
    }

    public static Map<String, Object> getMap(String jsonString) {
        if (!TextUtils.isEmpty(jsonString)) {
            try {
                return getMap(new JSONObject(jsonString));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return new HashMap<String, Object>();
    }

    public static Map<String, Object> getMap(JSONObject jsonObject) {
        Map<String, Object> map = new LinkedHashMap<>();

        Iterator<String> iterator = jsonObject.keys();
        while (iterator.hasNext()) {
            String key = iterator.next();
            try {
                if (!jsonObject.isNull(key)) {
                    map.put(key, jsonObject.get(key));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return map;
    }

    public static ContentValues getContentValues(String jsonString) {
        return getObject(jsonString, ContentValues.class);
    }

    public static ContentValues getContentValues(JSONObject jsonObject) {
        return getObject(jsonObject, ContentValues.class);
    }

    public static <TA> TA getObject(String jsonString, Class<TA> cls) {
        return getObject(jsonString, cls, new Gson());
    }

    private static <TA> TA getObject(String jsonString, Class<TA> cls, Gson gson) {
        if (cls == ContentValues.class) {
            try {
                return getObject(new JSONObject(jsonString), cls);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        try {
            return gson.fromJson(jsonString, cls);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    public static <TB> TB getObject(JSONObject jsonObject, Class<TB> cls) {
        if (cls == ContentValues.class) {
            Iterator<String> keys = jsonObject.keys();
            ContentValues values = new ContentValues();
            while (keys.hasNext()) {
                try {
                    String key = keys.next();
                    Object value = jsonObject.get(key);
                    int type = ReflectUtil.getClassType(value.getClass());
                    switch (type) {
                        case ReflectUtil.BOOLEAN:
                            values.put(key, (Boolean) value);
                            break;
                        case ReflectUtil.BYTE:
                            values.put(key, (Byte) value);
                            break;
                        case ReflectUtil.SHORT:
                            values.put(key, (Short) value);
                            break;
                        case ReflectUtil.INT:
                            values.put(key, (Integer) value);
                            break;
                        case ReflectUtil.LONG:
                            values.put(key, (Long) value);
                            break;
                        case ReflectUtil.FLOAT:
                            values.put(key, (Float) value);
                            break;
                        case ReflectUtil.DOUBLE:
                            values.put(key, (Double) value);
                            break;
                        case ReflectUtil.STRING:
                            values.put(key, (String) value);
                            break;
                        default:
                            values.put(key, ParseUtil.getJsonString(value));
                            break;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return (TB) values;
        }
        return getObject(jsonObject.toString(), cls);
    }

    public static <TC> List<TC> getObjects(String jsonString, Class<TC> cls) {
        try {
            return getObjects(new JSONArray(jsonString), cls);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new ArrayList<TC>();
    }

    public static <TC> List<TC> getObjects(JSONArray jsonArray, Class<TC> cls) {
        List<TC> objects = new ArrayList<TC>();
        Gson gson = new Gson();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                objects.add(getObject(jsonObject.toString(), cls, gson));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return objects;
    }

    public static String getJsonString(Object object) {
        return new Gson().toJson(object);
    }

    public static JSONObject getJsonObject(Object object) {
        try {
            return new JSONObject(getJsonString(object));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new JSONObject();
    }

    public static <T> ArrayList<T> parseList(ArrayList<T> listData, JSONArray list, Class<T> clazz) {
        if (listData == null)
            listData = new ArrayList<T>();

        if (list == null || list.length() <= 0) {
            return listData;
        }
        int len = list.length();
        for (int i = 0; i < len; i++) {
            listData.add(parse(list.optJSONObject(i), clazz));
        }
        return listData;
    }

    public static ArrayList<Object> parseListObject(ArrayList<Object> listData, JSONArray list, Class<?> clazz) {
        if (listData == null)
            listData = new ArrayList<Object>();

        if (list == null || list.length() <= 0) {
            return listData;
        }
        int len = list.length();
        for (int i = 0; i < len; i++) {
            listData.add(parse(list.optJSONObject(i), clazz));
        }
        return listData;
    }

    /**
     * @param obj
     * @param clazz
     * @return
     */
    public static <T> T parse(JSONObject obj, Class<T> clazz) {
        Constructor<?> con;
        T model = null;
        try {
            con = clazz.getConstructor(JSONObject.class);
            model = clazz.cast(con.newInstance(obj));
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return model;
    }

    public static JSONObject getJsonObject(Map<String, Object> map) {
        JSONObject jsonObject = new JSONObject();
        try {
            Map<String, Map<String, String>> maps = new HashMap<String, Map<String, String>>();
            Set<String> keys = map.keySet();
            for (String key : keys) {
                int index = key.indexOf(".");
                Object v = map.get(key);
                String value = null == v ? "" : v.toString();
                if (index == -1) {
                    jsonObject.put(key, value);
                } else {
                    String prefix = key.substring(0, index);
                    Map<String, String> temMap = maps.get(prefix);
                    if (temMap == null) {
                        temMap = new HashMap<>();
                        maps.put(prefix, temMap);
                    }
                    temMap.put(key.substring(index + 1), value);
                }
            }

            keys = maps.keySet();
            for (String key : keys) {
                jsonObject.put(key, getJsonObject(maps.get(key)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }
}
