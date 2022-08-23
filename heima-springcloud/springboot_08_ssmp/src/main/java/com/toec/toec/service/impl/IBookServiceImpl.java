package com.toec.toec.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.toec.toec.dao.BookDao;
import com.toec.toec.service.IBookService;
import com.toec.toec.domain.Book;
import org.springframework.stereotype.Service;

@Service
public class IBookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {
}
