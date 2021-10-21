package com.example.crawler_server.dao;

import com.example.crawler_server.entity.Task;

public interface ITaskDao {
    void push_task(Task task);

    Task pop_task(String spiderName, String taskType);
}
