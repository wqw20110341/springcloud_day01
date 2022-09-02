package com.toec;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class RedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public  void  set(){
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("age",41);
    }


    @Test
    public void contextLoads() {
        ValueOperations ops = redisTemplate.opsForValue();
        int age = (int) ops.get("age");
        System.out.println(age);
    }

    @Test
    public  void  hset(){
        HashOperations hash = redisTemplate.opsForHash();
        hash.put("info","q","z");
    }



    @Test
    public  void  hget(){
        HashOperations hash = redisTemplate.opsForHash();
        Object info = hash.get("info", "q");
        System.out.println(info);
    }


}
