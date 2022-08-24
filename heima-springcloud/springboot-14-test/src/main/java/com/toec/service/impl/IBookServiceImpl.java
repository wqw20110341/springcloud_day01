package com.toec.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.toec.dao.BookDao;
import com.toec.domain.Book;
import com.toec.service.IBookService;
import org.springframework.stereotype.Service;

@Service
public class IBookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {

}
