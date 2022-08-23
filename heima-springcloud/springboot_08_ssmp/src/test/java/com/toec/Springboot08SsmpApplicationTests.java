package com.toec;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.toec.toec.SsmApplication;
import com.toec.toec.dao.BookDao;
import com.toec.toec.service.impl.IBookServiceImpl;
import com.toec.toec.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes= SsmApplication.class)
class SsmApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private IBookServiceImpl iBookService;

    @Test
    public void testGetById(){
        Book book = iBookService.getById(4);
        System.out.println(book);
    }

    @Test
    void testSave(){
        Book book = new Book();
//        book.setId(10);
        book.setName("张验");
        book.setType("玉皇大帝");
        book.setDescription("zhang………………");
        iBookService.save(book);
    }

    @Test
    void testGetAll(){
        System.out.println(iBookService.list());
    }
    @Test
    void testGetPage(){
        IPage page = new Page(1,5);
        IPage iPage = iBookService.page(page);
        List list = iPage.getRecords();
        System.out.println(list.toString());
    }
    @Test
    void testDelete(){
        boolean removeById = iBookService.removeById(10);
        System.out.println(removeById);
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(10);
        book.setName("Redis实战56");
        book.setType("玉皇大帝");
        book.setDescription("zhang………………");
        iBookService.updateById(book);
    }

    @Test
    void testGetBy(){
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.like("name","Spring");
        IPage page = new Page(1,3);
        IPage iPage = iBookService.page(page, wrapper);
        List records = iPage.getRecords();
        System.out.println(records);
    }

    @Test
    void testGetBy2(){
        String name = "Spring";
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(name!=null,Book::getName,name);
        IPage page = new Page(2,3);
        IPage iPage =  iBookService.page(page, wrapper);
        List records = iPage.getRecords();
        System.out.println(records);
    }

    @Test
    void contextLoads() {
    }

}
