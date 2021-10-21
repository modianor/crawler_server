package com.example.crawler_server.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.crawler_server.entity.Task;

public class TaskUtil {
    public static String dump_task(Task task) {
        return JSON.toJSONString(task);
    }

    public static Task load_task(String task_json) {
        return JSON.parseObject(task_json, Task.class);
    }
}
