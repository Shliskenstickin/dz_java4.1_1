package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    private Product bookOne = new Book(1, "Том Сойер", 10, "Марк Твен");
    private Product bookTwo = new Book(2, "Война и мир", 10, "Лев Толстой");
    private Product bookThree = new Book(3, "Мастер и Маргарита", 10, "Михаил Булгаков");
    private Product smartphoneOne = new Smartphone(4, "IPhone 11", 10, "Apple");
    private Product smartphoneTwo = new Smartphone(5, "IPhone 6", 10, "Apple");
    private Product smartphoneThree = new Smartphone(6, "IPhone 12", 10, "Apple");

    @BeforeEach
    public void setUp() {
        repository.save(bookOne);
        repository.save(bookTwo);
        repository.save(bookThree);
        repository.save(smartphoneOne);
        repository.save(smartphoneTwo);
        repository.save(smartphoneThree);
    }

    @Test
    void removeById() {
        repository.removeById(1);
        Product[] expected = new Product[]{bookTwo, bookThree, smartphoneOne, smartphoneTwo, smartphoneThree};
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