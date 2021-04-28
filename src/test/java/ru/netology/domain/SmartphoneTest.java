package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    private Smartphone smartphone = new Smartphone(3, "iphone", 10, "apple");

    @Test
    void shouldFindMach() {
        assertTrue(smartphone.matches("apple"));
    }

    @Test
    void shouldNoFindMach() {
        assertFalse(smartphone.matches("aple"));
    }
}