package ru.geekbrains.spring2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring2.entities.Product;
import ru.geekbrains.spring2.entities.ProductDtos;
import ru.geekbrains.spring2.exceptions.ResourceNotFoundException;
import ru.geekbrains.spring2.services.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDtos> findAllProducts() {
        return productService.findAll().stream().map(p -> new ProductDtos(p.getId(), p.getTitle(), p.getPrice())).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public ProductDtos findProductsById(@PathVariable Long id) {
        Product p = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Продукт не найден. id: " + id));
        return new ProductDtos(p.getId(), p.getTitle(), p.getPrice());
    }

    @DeleteMapping("{id}")
    public void deleteProductsById(@PathVariable Long id) {
        productService.deleteById(id);
    }

}
