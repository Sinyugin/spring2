package ru.geekbrains.spring2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring2.entities.Product;
import ru.geekbrains.spring2.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> findAllProducts(){
        return productService.findAll();
    }

    @GetMapping("{id}")
    public Product findProductsById(@PathVariable Long id){
        return productService.findById(id).get();
    }

    @DeleteMapping("{id}")
    public void deleteProductsById(@PathVariable Long id){
        productService.deleteById(id);
    }

}
