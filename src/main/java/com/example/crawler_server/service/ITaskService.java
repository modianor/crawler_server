package com.example.crawler_server.service;

import com.example.crawler_server.entity.Task;

public interface ITaskService {
    void push_task(Task task);

    Task pop_task(String spiderName, String taskType);
}
