package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import java.security.SecureRandom;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    private Product book1 = new Book(1, "Том Сойер", 10, "Марк Твен");
    private Product book2 = new Book(2, "Война и мир", 10, "Лев Толстой");
    private Product book3 = new Book(3, "Мастер и Маргарита", 10, "Михаил Булгаков");
    private Product smartphone1 = new Smartphone(4, "IPhone 11", 10, "Apple");
    private Product smartphone2 = new Smartphone(5, "IPhone 6", 10, "Apple");
    private Product smartphone3 = new Smartphone(6, "IPhone 12", 10, "Apple");

    @BeforeEach
    public void setUp() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);
    }

    @Test
    void removeById() {
        repository.removeById(1);
        Product[] expected = new Product[]{book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeByNotFoundId() {
        assertThrows(NotFoundException.class, () -> repository.removeById(7));
    }

    @Test
    void shouldMessageIfRemoveByNotFoundId() {
        int id = 7;
        NotFoundException e = assertThrows(NotFoundException.class, () -> repository.removeById(id));

        String expected = "Element with id: " + id + " not found";
        String actual = e.getMessage();

        assertEquals(expected, actual);
    }
}