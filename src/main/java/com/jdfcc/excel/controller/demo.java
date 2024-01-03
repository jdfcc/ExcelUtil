package com.jdfcc.excel.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jdfcc.excel.entity.Target;
import com.jdfcc.excel.util.ExcelUtils;
import com.jdfcc.excel.util.ParseUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * @author Jdfcc
 * @HomePage <a href="https://github.com/Jdfcc">Jdfcc</a>
 * @Description test
 * @DateTime 2024/1/2 15:57
 */
@RestController
@RequestMapping("/test")
public class demo {

    @PostMapping
    void demoController(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws Exception {
        Map<String, JSONArray> map = ExcelUtils.readFileManySheet(file);
        Map<String, Target> targetMap = new LinkedHashMap<>();

        Set<String> sheetName = map.keySet();
        int ke = 0;
        for (String key : sheetName) {
            JSONArray object = map.get(key);
            for (int i = 0; i < object.size(); i++) {
                JSONObject object1 = object.getJSONObject(i);
                String string = object1.toString();
                Target target = ParseUtil.parseJson(string, Target.class);
                System.out.println(target);
                targetMap.put(String.valueOf(++ke), target);
            }
        }
        Collection<Target> values = targetMap.values();
        List<Target> list = values.stream().toList();
        ExcelUtils.export(response, "结果", list, Target.class);
    }
}
