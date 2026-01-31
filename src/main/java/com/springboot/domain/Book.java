
package com.springboot.domain;

import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "book")
public class Book implements Serializable {

    @Id
    @Column(name = "book_id", length = 20)
    private String bookId;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "author", length = 100, nullable = false)
    private String author;

    @Column(name = "description", length = 300)
    private String description;

    @Column(name = "publisher", length = 50, nullable = false)
    private String publisher;

    @Column(name = "category", length = 20, nullable = false)
    private String category;

    @Column(name = "units_in_stock")
    private long unitsInStock;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "book_condition", length = 20, nullable = false)
    private String condition;

    @Column(name = "file_name", length = 30)
    private String filename;

    public Book() {
        // 기본 생성자
    }
}