package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Product bookOne = new Book(1, "Том Сойер", 10, "Марк Твен");
    private Product bookTwo = new Book(2, "Война и мир", 10, "Лев Толстой");
    private Product bookThree = new Book(3, "Мастер и Маргарита", 10, "Михаил Булгаков");
    private Product smartphoneOne = new Smartphone(4, "IPhone 11", 10, "Apple");
    private Product smartphoneTwo = new Smartphone(5, "IPhone 6", 10, "Apple");
    private Product smartphoneThree = new Smartphone(6, "IPhone 12", 10, "Apple");

    @BeforeEach
    public void setUp() {
        manager.add(bookOne);
        manager.add(bookTwo);
        manager.add(bookThree);
        manager.add(smartphoneOne);
        manager.add(smartphoneTwo);
        manager.add(smartphoneThree);
    }

    @Test
    void shouldSearchBookByAuthor() {
        Product[] expected = new Product[]{bookTwo};
        Product[] actual = manager.searchBy("Лев Толстой");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByName() {
        Product[] expected = new Product[]{bookTwo};
        Product[] actual = manager.searchBy("Война и мир");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByCompany() {
        Product[] expected = new Product[]{smartphoneOne, smartphoneTwo, smartphoneThree};
        Product[] actual = manager.searchBy("Apple");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByName() {
        Product[] expected = new Product[]{smartphoneThree};
        Product[] actual = manager.searchBy("IPhone 12");

        assertArrayEquals(expected, actual);
    }

    @Test
    void notFound() {
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("IPhone");

        assertArrayEquals(expected, actual);
    }
}