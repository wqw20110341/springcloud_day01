package com.springboot17mongodb;

import com.springboot17mongodb.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Iterator;
import java.util.List;

@SpringBootTest
class MongoApplicationTests {


    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void contextLoadsSave() {
        Book book = new Book();
        book.setId(2);
        book.setName("www");
        book.setType("springboot222");
        book.setDescription("it");
        mongoTemplate.save(book);
    }


    @Test
    void findAll() {
        List<Book> books = mongoTemplate.findAll(Book.class);
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    void contextLoadsAAA() {
//        new Query()
//        mongoTemplate.find(,);
    }





    @Test
    void contextLoads() {
        Book book = new Book();
        book.setId(1);
        book.setName("123456");
        book.setType("springboot");
        book.setDescription("it");
        mongoTemplate.save(book);
    }



}
