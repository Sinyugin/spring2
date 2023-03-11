package ru.geekbrains.spring2.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring2.aspect.Timer;
import ru.geekbrains.spring2.dtos.Cart;
import ru.geekbrains.spring2.entities.Product;
import ru.geekbrains.spring2.exceptions.ResourceNotFoundException;

@Service
@Slf4j
@RequiredArgsConstructor
public class CartService {
    private final ProductService productService;
    private Cart tempCart;

    @PostConstruct
    public void init() {
        tempCart = new Cart();
    }

    @Timer
    public Cart getCurrentCart() {
        return tempCart;
    }

    @Timer
    public void add(Long productId) {
        Product product = productService.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Не удается добавить продукт с id: " + productId + " в корзину. Продукт не найден"));
        tempCart.add(product);
    }

    @Timer
    public void crear() {
        tempCart.clear();
    }

    @Timer
    public void deleteById(Long productId) {
        tempCart.dellProduct(productId);

    }
}
