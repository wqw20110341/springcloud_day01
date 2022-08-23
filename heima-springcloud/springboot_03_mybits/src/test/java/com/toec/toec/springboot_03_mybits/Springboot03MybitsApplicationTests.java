package com.toec.toec.springboot_03_mybits;

import com.toec.toec.dao.BookDao;
import com.toec.toec.Springboot03MybitsApplication;
import com.toec.toec.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest(classes = Springboot03MybitsApplication.class)
class Springboot03MybitsApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
        Book book = bookDao.getById(1);
        System.out.println(book.toString());
    }

    @Test
    void contextLoadsRedis() {
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("age",41);
        ops.set("name","www");
        System.out.println(ops.get("age"));
    }


}
