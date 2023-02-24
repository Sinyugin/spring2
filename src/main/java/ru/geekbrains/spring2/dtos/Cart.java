package ru.geekbrains.spring2.dtos;

import lombok.Data;
import ru.geekbrains.spring2.entities.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class Cart {
    private List<CartItem> items;
    private int totalPrice;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void add(Product product) { //TODO: Доработать в ДЗ

        if (items.size() == 0) {
            items.add(new CartItem(product.getId(), product.getTitle(), 1, product.getPrice(), product.getPrice()));
        } else {
            for (CartItem cartItem : items) {
                //если id совпали увеличиваем поле Количество на единицу
                //пересчитываем итоговую сумму
                if (cartItem.getProductId().equals(product.getId())) {
                    cartItem.setQuantity(cartItem.getQuantity() + 1);
                    recalculate();
                    return;
                }
            }
            items.add(new CartItem(product.getId(), product.getTitle(), 1, product.getPrice(), product.getPrice()));
        }
        recalculate();
    }

    private void recalculate() {
        totalPrice = 0;
        for (CartItem item : items) {
            totalPrice += (item.getPrice() * item.getQuantity());
        }
    }

    public void clear() {
        items.removeAll(items);
    }

    public void dellProduct(Long productId) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProductId().equals(productId)) {
                items.remove(items.get(i));
            }
        }
    }
}
