package com.example;

import com.example.pojo.User;
import com.example.utils.RedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Springboot10RedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void test1(){
        redisUtil.set("name", "test3");
        System.out.println(redisUtil.get("name"));
    }

    @Test
    void contextLoads() {

        redisTemplate.opsForValue().set("k1", "v1");

        System.out.println(redisTemplate.opsForValue().get("k1"));
    }

    @Test
    public void test() throws JsonProcessingException {

        User user = new User("user", 11);

        String joinUser = new ObjectMapper().writeValueAsString(user);

        redisTemplate.opsForValue().set("user", joinUser);

        System.out.println(redisTemplate.opsForValue().get("user"));
    }

}
