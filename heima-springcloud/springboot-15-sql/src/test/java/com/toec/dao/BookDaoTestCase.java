package com.toec.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.toec.SqlApplication;
import com.toec.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = SqlApplication.class)
public class BookDaoTestCase {

    @Autowired
    private BookDao bookDao;

    @Test
    public void testGetById(){
        Book book = bookDao.selectById(1);
        System.out.println(book);
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setId(2);
        book.setName("zhang///");
        book.setType("玉皇大帝");
        book.setDescription("zhang………………");
        bookDao.insert(book);
    }

    @Test
    void testGetAll(){
        System.out.println(bookDao.selectList(null));
    }
    @Test
    void testGetPage(){
        IPage page = new Page(1,5);
        IPage iPage = bookDao.selectPage(page, null);
        List list = iPage.getRecords();
        System.out.println(list.toString());
    }
    @Test
    void testDelete(){
        bookDao.deleteById(7);
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(5);
        book.setName("Redis实战56");
        book.setType("玉皇大帝");
        book.setDescription("zhang………………");
        bookDao.updateById(book);
    }

    @Test
    void testGetBy(){
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.like("name","Spring");
        IPage page = new Page(1,3);
        IPage iPage = bookDao.selectPage(page, wrapper);
        List records = iPage.getRecords();
        System.out.println(records);
    }

    @Test
    void testGetBy2(){
        String name = "Spring";
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(name!=null,Book::getName,name);
        IPage page = new Page(1,3);
        IPage iPage = bookDao.selectPage(page, wrapper);
        List records = iPage.getRecords();
        System.out.println(records);
    }


}
