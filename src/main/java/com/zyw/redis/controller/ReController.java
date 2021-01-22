package com.zyw.redis.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
@Slf4j
public class ReController {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @GetMapping("/redis")
    public String test(){
        Map<String,Object> cacheMap = new HashMap<>(16);
        cacheMap.put("name","zhuyanwu");
        cacheMap.put("id",1);
        cacheMap.put("salary",1000000);
        redisTemplate.opsForHash().putAll("all_cache",cacheMap);
        return (String) redisTemplate.opsForHash().get("all_cache","name");
    }

}
