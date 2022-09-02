package com.toec.toec.service.impl;

import com.alicp.jetcache.anno.*;
import com.toec.dao.BookDao;
import com.toec.domain.Book;
import com.toec.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    @CacheUpdate(name="book_",key="#book.id",value = "#book")
    public Boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    @CacheInvalidate(name="book_",key = "#id")
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0 ;
    }

    @Override
    @Cached(name="book",key="#id",expire = 3600,cacheType = CacheType.REMOTE)
//    @CacheRefresh(refresh = 50)
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }
}
