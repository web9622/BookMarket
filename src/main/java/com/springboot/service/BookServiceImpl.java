package com.springboot.service;

import com.springboot.domain.Book;
import com.springboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBookList() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(String bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("도서 아이디:" + bookId + "에 해당하는 도서가 없습니다."));
    }

    @Override
    public void setNewBook(Book book) {
        bookRepository.save(book);
    }
}
