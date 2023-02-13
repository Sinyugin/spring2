package ru.geekbrains.spring2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring2.entities.ProductInCart;

@Repository
public interface ProductInCartRepository extends JpaRepository<ProductInCart, Long> {
}
