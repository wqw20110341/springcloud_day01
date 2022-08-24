package com.toec.controller;

import com.toec.domain.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

//    @GetMapping
//    public String getById(){
//        System.out.println("getById is running  ……………………  ");
//        return "springboot";
//    }

    @GetMapping
    public Book getById(){
        System.out.println("getById is running  ……………………  ");

        Book book = new Book();
        book.setId(12);
        book.setName("springboot");
        book.setType("spring");
        book.setDescription("------------");

        return book;
    }
}
