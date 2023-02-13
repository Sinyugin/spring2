package ru.geekbrains.spring2.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring2.entities.Product;
import ru.geekbrains.spring2.entities.ProductInCart;
import ru.geekbrains.spring2.repositories.ProductInCartRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final ProductService productService;
    private ProductInCart productInCart;
    @PostConstruct
            public void init(){
        productInCart = new ProductInCart();
    }

    private final ProductInCartRepository productInCartRepository;

    public List<ProductInCart> findAll() {
        return productInCartRepository.findAll();
    }

    public void addInCart(Long id) {

        //**Не пойму почему при добавлениив в корзину продукты добавляются в той же нумерации как и в списке магазина
        // Почему я не могу добавить продукт в корзину больше одного раза**//

        Product product = productService.findById(id).get();
        productInCart.setId(product.getId());
        productInCart.setTitle(product.getTitle());
        productInCart.setPrice(product.getPrice());
        productInCart.setQuantity(1);
        productInCartRepository.save(productInCart);
    }

    public void deleteById(Long id) {
        productInCartRepository.deleteById(id);
    }
}
