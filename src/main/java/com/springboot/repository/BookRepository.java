package com.springboot.repository;

import com.springboot.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    // JPA가 자동으로 CRUD 메소드 구현
    // findAll(), findById(), save(), delete() 등 기본 제공
}
