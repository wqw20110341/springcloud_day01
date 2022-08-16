package com.www;

import com.Application;
import com.dao.impl.BookDaoImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Application.class)
public class ApplicationTests {
    @Autowired
    private BookDaoImpl bookDaoImpl = new BookDaoImpl();

    @Test
    public void contextLoads() {
        bookDaoImpl.save();
    }

}
