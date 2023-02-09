package ru.netology.classes.book;

import lombok.*;
import ru.netology.classes.Product;

@Getter
@Setter


public class Book extends Product {
    protected String author;

    public Book() {
    }

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }
}
