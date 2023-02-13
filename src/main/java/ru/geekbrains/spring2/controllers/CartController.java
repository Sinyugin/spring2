package ru.geekbrains.spring2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring2.entities.ProductInCart;
import ru.geekbrains.spring2.services.CartService;
import ru.geekbrains.spring2.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    @GetMapping()
    public List<ProductInCart> findAllProducts(){
        return cartService.findAll();
    }

    @GetMapping("/add/{id}")
    public void findProductsById(@PathVariable Long id) {
        cartService.addInCart(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteInCartById(@PathVariable Long id) {
        cartService.deleteById(id);
    }
}
