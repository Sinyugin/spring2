package ru.geekbrains.spring2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring2.dtos.Cart;
import ru.geekbrains.spring2.services.CartService;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id) {
        cartService.add(id);
    }

    @GetMapping
    public Cart getCurrentCart() {
        return cartService.getCurrentCart();
    }

    @GetMapping("/clean")
    public void cleanCart() {
        cartService.crear();
    }

    @GetMapping("/delete/{id}")
    public void deleteProductsById(@PathVariable Long id) {
        cartService.deleteById(id);
    }
}
