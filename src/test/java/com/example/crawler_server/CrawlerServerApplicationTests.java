package com.example.crawler_server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.crawler_server.entity.Task;
import com.example.crawler_server.utils.TaskUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Set;

@SpringBootTest
class CrawlerServerApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void redis_read() {
        redisTemplate.opsForZSet().incrementScore("redis:zset", "set_1", 1);
        redisTemplate.opsForZSet().incrementScore("redis:zset", "set_2", 1);
        redisTemplate.opsForZSet().incrementScore("redis:zset", "set_3", 1);
        redisTemplate.opsForZSet().incrementScore("redis:zset", "set_4", 1);
        redisTemplate.opsForZSet().incrementScore("redis:zset", "set_5", 1);
        Set<Object> tasks = redisTemplate.opsForZSet().range("redis:zset", 1, 3);
        for (Object task : tasks) {
            System.out.println(task);
        }
    }


    @Test
    void redis_write() {
        /*Task task = new Task(
                43254546565757L,
                43255846565757L,
                "heimao",
                "List",
                "https://weibo.cn/comment/hot/IDl56i8av?rl=1&page=2",
                "",
                "",
                "",
                5,
                false,
                "",
                "",
                "",
                ""
        );
        String redisKey = "heimao:List";
        System.out.println(JSON.toJSONString(task));
        Boolean flag = redisTemplate.opsForZSet().add(redisKey, TaskUtil.dump_task(task), 10);
        System.out.println(flag);*/
    }
}
