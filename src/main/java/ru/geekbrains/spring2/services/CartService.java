package ru.geekbrains.spring2.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring2.dtos.Cart;
import ru.geekbrains.spring2.entities.Product;
import ru.geekbrains.spring2.exceptions.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductService productService;
    private Cart tempCart;

    @PostConstruct
    public void  init(){
        tempCart = new Cart();
    }

    public Cart getCurrentCart(){
        return tempCart;
    }

    public void add(Long productId){
        Product product = productService.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Не удается добавить продукт с id: " + productId + " в корзину. Продукт не найден"));
        tempCart.add(product);
    }

    public void crear(){
        tempCart.clear();
    }

    public void deleteById(int productId) {
        tempCart.dellProduct(productId);
    }
}
