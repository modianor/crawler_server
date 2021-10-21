package com.example.crawler_server.dao.daoImp;

import com.example.crawler_server.dao.ITaskDao;
import com.example.crawler_server.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class TaskDao implements ITaskDao {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void push_task(Task task) {
        String spiderName = task.spider_name;
        String taskType = task.task_type;
        String taskKey = spiderName + ":" + taskType;
        redisTemplate.opsForZSet().add(taskKey, task, 1);
    }

    @Override
    public Task pop_task(String spiderName, String taskType) {
        String taskKey = spiderName + ":" + taskType;
        Set<Object> objs = redisTemplate.opsForZSet().range(taskKey, 0, 1);
        Task task = null;
        if (objs != null && objs.size() > 0) {
            for (Object obj : objs) {
                task = (Task) (obj);
                return task;
            }
        }
        return task;
    }
}
