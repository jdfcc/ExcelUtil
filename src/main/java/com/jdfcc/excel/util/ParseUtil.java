package com.jdfcc.excel.util;

import com.alibaba.fastjson.JSONObject;
import com.jdfcc.excel.annotation.ExcelImport;

import java.lang.reflect.Field;


/**
 * @author Jdfcc
 * @HomePage <a href="https://github.com/Jdfcc">Jdfcc</a>
 * @Description 将json转化为对象，配合 ExcelImport注解使用
 * @DateTime 2023/12/12 11:40
 */
@SuppressWarnings("unused")
public class ParseUtil {

    public static <T> T parseJson(String jsonString, Class<T> clazz) {
        try {
            // 解析 JSON
            JSONObject jsonObject = JSONObject.parseObject(jsonString);

            // 创建对象实例
            T instance = clazz.getDeclaredConstructor().newInstance();

            // 获取类的所有字段
            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {
                // 检查字段上是否有 ChineseKey 注解
                if (field.isAnnotationPresent(ExcelImport.class)) {
                    // 获取注解的值（中文键）
                    ExcelImport excelImport = field.getAnnotation(ExcelImport.class);
                    String key = excelImport.value();

                    // 使用反射设置私有字段的访问权限
                    field.setAccessible(true);

                    // 从 JSON 中获取值并设置到对象实例中
                    field.set(instance, jsonObject.getString(key));
                }
            }

            return instance;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
