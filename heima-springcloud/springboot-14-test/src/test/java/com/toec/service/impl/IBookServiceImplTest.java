package com.toec.service.impl;

import com.toec.domain.Book;
import com.toec.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(false)
public class IBookServiceImplTest {

    @Autowired
    private BookService bookService;

    @Test
    void testSave(){
        Book book = new Book();
        book.setName("zhang2222222222222222222222///");
        book.setType("王");
        book.setDescription("zhang………………");
        bookService.save(book);
    }
}