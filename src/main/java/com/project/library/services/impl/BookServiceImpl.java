package com.project.library.services.impl;

import com.project.library.models.Book;
import com.project.library.repositories.BookRepository;
import com.project.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable){
        return bookRepository.findAll(pageable);
    }
}
