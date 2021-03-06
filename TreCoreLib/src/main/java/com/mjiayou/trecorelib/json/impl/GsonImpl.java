package com.mjiayou.trecorelib.json.impl;

import com.google.gson.Gson;
import com.mjiayou.trecorelib.helper.GsonHelper;
import com.mjiayou.trecorelib.json.JsonParser;

import java.lang.reflect.Type;

/**
 * Created by treason on 2018/9/29.
 */

public class GsonImpl extends JsonParser {

    private Gson mGson = GsonHelper.get();

    @Override
    public String toJson(Object object) {
        return mGson.toJson(object);
    }

    @Override
    public <T> T toObject(String json, Class<T> clazz) {
        return mGson.fromJson(json, clazz);
    }

    @Override
    public <T> T toObject(String json, Type type) {
        return mGson.fromJson(json, type);
    }

    @Override
    public <T> T toObject(byte[] bytes, Class<T> clazz) {
        return mGson.fromJson(new String(bytes), clazz);
    }
}
