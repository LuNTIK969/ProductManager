package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.classes.book.Book;
import ru.netology.classes.Product;
import ru.netology.classes.smartphone.Smartphone;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    Repository repo = new Repository();
    ProductManager manager = new ProductManager(repo);

    Product bookOne = new Book(1, "Best choice", 928, "Торстен Гавенер");
    Product bookTwo = new Book(2, "Harry Potter Boxed Set. Complete Collection", 7_612, "Joanne Rowling");
    Product smartphoneOne = new Smartphone(5, "OnePlus 7Pro", 44_000, "BBK Electronics");
    Product smartphoneTwo = new Smartphone(6, "Best choice", 48_000, "BBK Electronics");

    @BeforeEach
    public void setAll() {
        manager.save(bookOne);
        manager.save(bookTwo);
        manager.save(smartphoneOne);
        manager.save(smartphoneTwo);
    }

    @Test
    public void shouldFindNameSmartphone() {
        Product[] expected = {smartphoneOne};
        Product[] actual = manager.searchBy("OnePlus 7Pro");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByNameBook() {
        Product[] expected = {bookTwo};
        Product[] actual = manager.searchBy("Harry Potter Boxed Set. Complete Collection");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearch() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Quest");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSeveral() {
        Product[] expected = {bookOne, smartphoneTwo};
        Product[] actual = manager.searchBy("Best choice");

        assertArrayEquals(expected, actual);
    }

}