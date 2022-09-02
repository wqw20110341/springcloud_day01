//package com.toec.service.impl;
//
//import com.toec.domain.Book;
//import com.toec.service.BookRepository;
//import com.toec.service.BookService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service("bookService")
//public class BookServiceImpl implements BookService {
//
//    @Autowired
//    @Qualifier("bookRepository")
//    private BookRepository bookRepository;
//
//
//    @Override
//    public Optional<Book> findById(String id) {
//        return bookRepository.findById(id);
//    }
//
//    @Override
//    public Book save(Book book) {
//        return bookRepository.save(book);
//    }
//
//    @Override
//    public void delete(Book book) {
//        bookRepository.delete(book);
//    }
//
//    @Override
//    public List<Book> findAll() {
//        return (List<Book>) bookRepository.findAll();
//    }
//
//    @Override
//    public Page<Book> findByFilter(String type, PageRequest pageRequest) {
//        return bookRepository.findAll(pageRequest);
//    }
//}
