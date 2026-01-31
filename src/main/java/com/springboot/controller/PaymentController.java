package com.springboot.controller;

import com.springboot.domain.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @GetMapping
    public String showPayment(HttpSession session, Model model) {
        @SuppressWarnings("unchecked")
        List<Cart> cartList = (List<Cart>) session.getAttribute("cartlist");

        BigDecimal totalAmount = BigDecimal.ZERO;
        if (cartList != null) {
            for (Cart cart : cartList) {
                BigDecimal itemTotal = cart.getBook().getUnitPrice()
                        .multiply(BigDecimal.valueOf(cart.getQuantity()));
                totalAmount = totalAmount.add(itemTotal);
            }
        }

        model.addAttribute("cartlist", cartList);
        model.addAttribute("totalAmount", totalAmount);

        return "payment";
    }
}
