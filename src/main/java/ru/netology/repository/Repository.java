package ru.netology.repository;

import ru.netology.classes.Product;

public class Repository {
    protected Product[] products = new Product[0];

    public Product[] addProduct(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
        return products.clone();
    }

    public void removeById(int id) {
        Product[] tmp = new Product[products.length - 1];
        int temporaryCopy = 0;
        for (Product poster : products) {
            if (poster.getId() != id) {
                tmp[temporaryCopy] = poster;
                temporaryCopy++;
            }
        }
        products = tmp;
    }

    public Product[] findAll() {
        return products == null ? null : products.clone();
    }


}
