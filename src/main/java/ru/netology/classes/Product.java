package ru.netology.classes;

import lombok.*;

@Getter
@Setter


public class Product {
    protected int id;
    protected String name;
    protected int price;

    public Product() {
    }

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
