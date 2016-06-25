package com.redis.service.impl;


import com.redis.service.PubService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class PubServiceImpl implements PubService {
    @Resource(name = "stringRedisTemplate")
    private StringRedisTemplate stringRedisTemplate;

    private String channelTopic = "user:topic";

    /*发布消息到Channel*/
    public void Publisher(String message) {
        stringRedisTemplate.convertAndSend(channelTopic, message);
    }
}
