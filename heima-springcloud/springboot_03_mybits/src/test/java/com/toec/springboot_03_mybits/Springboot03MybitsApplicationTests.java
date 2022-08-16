package com.toec.springboot_03_mybits;

import com.toec.Springboot03MybitsApplication;
import com.toec.dao.BookDao;
import com.toec.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Springboot03MybitsApplication.class)
class Springboot03MybitsApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
        Book book = bookDao.getById(1);
        System.out.println(book.toString());
    }

}
