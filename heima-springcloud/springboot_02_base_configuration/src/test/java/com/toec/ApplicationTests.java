package com.toec;

import com.toec.dao.impl.BookDaoImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationTests {
    @Autowired
    private BookDaoImpl bookDaoImpl = new BookDaoImpl();

//    @Value("${servers.timeout}")
//    private String msg;

    @Value("${datasource.password}")
    private String password;

    @Test
    public void contextLoads() {
        System.out.println(password);
//        System.out.println(msg);
//        bookDaoImpl.save();
    }

}
