package com.toec.dao.impl;

import com.toec.dao.book.BookDao;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("book dao is running…………………………");
    }
}
