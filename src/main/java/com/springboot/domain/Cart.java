package com.springboot.domain;

import lombok.Data;
import java.io.Serializable;

@Data
public class Cart implements Serializable {
    private String cartId;
    private Book book;
    private int quantity;

    public Cart() {
    }

    public Cart(Book book) {
        this.book = book;
        this.quantity = 1;
    }
}
