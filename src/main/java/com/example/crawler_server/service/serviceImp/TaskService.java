package com.example.crawler_server.service.serviceImp;

import com.example.crawler_server.dao.ITaskDao;
import com.example.crawler_server.entity.Task;
import com.example.crawler_server.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService implements ITaskService {

    @Autowired
    private ITaskDao iTaskDao;

    @Override
    public void push_task(Task task) {
        iTaskDao.push_task(task);
    }

    @Override
    public Task pop_task(String spiderName, String taskType) {
        return iTaskDao.pop_task(spiderName, taskType);
    }
}
