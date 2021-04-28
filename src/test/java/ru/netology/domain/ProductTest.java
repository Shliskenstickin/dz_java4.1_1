package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    private Product product = new Product(1, "Phone", 10);

    @Test
    void shouldFindMach() {
        assertTrue(product.matches("Phone"));
    }

    @Test
    void shouldNoFindMach() {
        assertFalse(product.matches("Phone1"));
    }
}
