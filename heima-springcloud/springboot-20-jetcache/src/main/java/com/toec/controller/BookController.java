package com.toec.controller;

import com.toec.domain.Book;
import com.toec.service.BookService;
import com.toec.utils.ResultInfo;
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
    private BookService bookService;

    @GetMapping
    public ResultInfo getAll(){
        List<Book> list = bookService.getAll();
        ResultInfo resultInfo = new ResultInfo(true, list);
        return resultInfo;
    }

    @PostMapping
    public ResultInfo save(@RequestBody  Book book){
        boolean save = bookService.save(book);
        ResultInfo resultInfo = new ResultInfo(save);
        return resultInfo;
    }

    @PutMapping
    public ResultInfo update(@RequestBody Book book){
        boolean updateById = bookService.update(book);
        ResultInfo resultInfo = new ResultInfo(updateById);
        return resultInfo;
    }

    @DeleteMapping("{id}")
    public ResultInfo delete(@PathVariable Integer id){
        boolean removeById = bookService.delete(id);
        ResultInfo resultInfo = new ResultInfo(removeById);
        return resultInfo;
    }

    @GetMapping("{id}")
    public ResultInfo getById(@PathVariable Integer id){
        Book byId = bookService.getById(id);
        ResultInfo resultInfo = new ResultInfo(true,byId);
        return resultInfo;
    }

}
