package com.toec;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class StringRedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public  void  set(){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("age","41");
    }

    @Test
    public void get(){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        String name = ops.get("age");
        System.out.println(name);
    }



    @Test
    public void contextLoads() {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        String age = ops.get("age");
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
