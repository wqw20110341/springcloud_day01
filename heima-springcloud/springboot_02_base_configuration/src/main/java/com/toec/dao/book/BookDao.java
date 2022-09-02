package com.toec.dao.book;

import java.awt.print.Book;

public interface BookDao {
    public void save();

    public Book getById(Integer id);
}
