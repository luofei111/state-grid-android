package com.nun.lib_base.http;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LuoFei on 2018/4/2.
 * <p>
 * 解析json/xml帮助类
 */

public class GsonHelper {

    static Gson gson = new Gson();
    static JsonParser jsonParser = new JsonParser();

    /**
     * 根据json和返回值类型，返回对应的返回值
     *
     * @param jsonString
     * @param entityClass
     * @param <T>
     * @return
     */
    public static <T> T convertEntity(String jsonString, Class<T> entityClass) {
        T entity = null;
        try {
            entity = gson.fromJson(jsonString.toString(), entityClass);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entity;
    }


    /**
     * 根据json和返回值的列表的子类型，解析到列表
     *
     * @param jsonString
     * @param entityclass//列表中的子类型
     * @param <T>
     * @return
     */
    public static <T> List<T> convertEntities(String jsonString, Class<T> entityclass) {
        List<T> entities = new ArrayList<>();
        try {
            JsonArray jsonArray = jsonParser.parse(jsonString).getAsJsonArray();
            for (JsonElement element : jsonArray) {
                entities.add(gson.fromJson(element, entityclass));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entities;
    }

    public static String objectToJSONString(Object object) {
        String coverStr = gson.toJson(object);
        return coverStr;
    }
}
