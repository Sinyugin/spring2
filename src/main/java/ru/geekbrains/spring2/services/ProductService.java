package ru.geekbrains.spring2.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring2.aspect.Timer;
import ru.geekbrains.spring2.entities.Product;
import ru.geekbrains.spring2.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Timer
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Timer
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Timer
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

}
