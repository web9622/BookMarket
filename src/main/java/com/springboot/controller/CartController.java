package com.springboot.controller;

import com.springboot.domain.Book;
import com.springboot.domain.Cart;
import com.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String getCart(HttpSession session, Model model) {
        @SuppressWarnings("unchecked")
        List<Cart> cartList = (List<Cart>) session.getAttribute("cartlist");
        if (cartList == null) {
            cartList = new ArrayList<>();
        }
        model.addAttribute("cartlist", cartList);
        return "cart";
    }

    @PostMapping("/add/{bookId}")
    public String addToCart(@PathVariable String bookId, HttpSession session) {
        Book book = bookService.getBookById(bookId);

        @SuppressWarnings("unchecked")
        List<Cart> cartList = (List<Cart>) session.getAttribute("cartlist");
        if (cartList == null) {
            cartList = new ArrayList<>();
            session.setAttribute("cartlist", cartList);
        }

        // 이미 장바구니에 있는지 확인
        boolean found = false;
        for (Cart cart : cartList) {
            if (cart.getBook().getBookId().equals(bookId)) {
                cart.setQuantity(cart.getQuantity() + 1);
                found = true;
                break;
            }
        }

        if (!found) {
            Cart newCart = new Cart(book);
            cartList.add(newCart);
        }

        return "redirect:/cart";
    }

    @GetMapping("/remove/{index}")
    public String removeFromCart(@PathVariable int index, HttpSession session) {
        @SuppressWarnings("unchecked")
        List<Cart> cartList = (List<Cart>) session.getAttribute("cartlist");
        if (cartList != null && index < cartList.size()) {
            cartList.remove(index);
        }
        return "redirect:/cart";
    }
}
