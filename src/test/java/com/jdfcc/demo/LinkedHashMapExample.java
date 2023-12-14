package com.jdfcc.demo;

/**
 * @author Jdfcc
 * @HomePage <a href="https://github.com/Jdfcc">Jdfcc</a>
 * @Description TODO
 * @DateTime 2023/12/12 14:59
 */
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        // 创建一个有序的 LinkedHashMap
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();

        // 向 LinkedHashMap 中插入键值对
        linkedHashMap.put("one", 1);
        linkedHashMap.put("two", 2);
        linkedHashMap.put("2334", 1);
        linkedHashMap.put("three", 3);

        // 获取 keySet，这个 keySet 是有序的
        Set<String> keySet = linkedHashMap.keySet();

        // 输出 keySet 中的键，顺序是插入的顺序
        for (String key : keySet) {
            System.out.println(key);
        }
    }
}
