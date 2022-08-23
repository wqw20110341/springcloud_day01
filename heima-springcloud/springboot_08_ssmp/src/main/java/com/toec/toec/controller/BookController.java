package com.toec.toec.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.toec.toec.domain.Book;
import com.toec.toec.domain.BookFilter;
import com.toec.toec.service.impl.IBookServiceImpl;
import com.toec.toec.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**表示层
 *
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookServiceImpl iBookService;

    @GetMapping
    public ResultInfo getAll(){
        List<Book> list = iBookService.list();
        ResultInfo resultInfo = new ResultInfo(true, list);
        System.out.println("===============");
        System.out.println("---------------------");
        System.out.println("+++++++++++++++++++++++");
        return resultInfo;
    }

    @PostMapping
    public ResultInfo save(@RequestBody  Book book){
        boolean save = iBookService.save(book);
        ResultInfo resultInfo = new ResultInfo(save);
        return resultInfo;
    }

    @PutMapping
    public ResultInfo update(@RequestBody Book book){
        boolean updateById = iBookService.updateById(book);
        ResultInfo resultInfo = new ResultInfo(updateById);
        return resultInfo;
    }

    @DeleteMapping("{id}")
    public ResultInfo delete(@PathVariable Integer id){
        boolean removeById = iBookService.removeById(id);
        ResultInfo resultInfo = new ResultInfo(removeById);
        return resultInfo;
    }

    @GetMapping("{id}")
    public ResultInfo getById(@PathVariable Integer id){
        Book byId = iBookService.getById(id);
        ResultInfo resultInfo = new ResultInfo(true,byId);
        return resultInfo;
    }

    @PostMapping("/filter")
    public ResultInfo getPage(@RequestBody BookFilter bookFilter){
        int curPage = bookFilter.getPage();
        int pageSize = bookFilter.getPageSize();
        Page page = new Page(curPage, pageSize);
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        String name = bookFilter.getName();
        String type = bookFilter.getType();
        String description = bookFilter.getDescription();
        wrapper.like(name!=null,Book::getName,name);
        wrapper.like(type!=null,Book::getType,type);
        wrapper.like(description!=null,Book::getDescription,description);
        Page pageResult = iBookService.page(page, wrapper);

        if(curPage > pageResult.getPages()){
            page.setCurrent(pageResult.getPages());
            pageResult = iBookService.page(page, wrapper);
        }
        ResultInfo resultInfo = new ResultInfo(true, pageResult);
        return resultInfo;
    }
}
