package com.toec.dao.impl;

import com.toec.dao.book.BookDao;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;

@Repository
public class BookDaoImpl implements BookDao {

    @Override
    public void save() {
        System.out.println("book dao is running…………………………");
    }

    @Override
    @Cacheable(value="cacheSpace",key="#id")
    public Book getById(Integer id) {
        return null;
    }
}
