package com.example.crawler_server.controller;

import com.example.crawler_server.entity.Task;
import com.example.crawler_server.service.ITaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/task")
public class TaskController {
    private final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private ITaskService iTaskService;

    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadTask(Task task) {
        logger.info(String.valueOf(task));
        iTaskService.push_task(task);
        return "";
    }

    @RequestMapping(path = "/getTask", method = RequestMethod.GET)
    @ResponseBody
    public Task getTask(@RequestParam("spider_name") String spiderName, @RequestParam("task_type") String taskType) {
        logger.info(spiderName + ":" + taskType);
        return iTaskService.pop_task(spiderName, taskType);
    }
}
