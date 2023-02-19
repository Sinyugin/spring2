package ru.geekbrains.spring2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDtos {

    public Long id;
    private String title;
    private int price;
}
