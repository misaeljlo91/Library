package com.project.library.services;

import com.project.library.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<Book> getAll(Pageable pageable);
}
