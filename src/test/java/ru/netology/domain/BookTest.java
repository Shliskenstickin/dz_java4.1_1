package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book book = new Book(1, "Sad if the Brain", 10, "Mushroomeater");

    @Test
    void shouldFindMach() {
        assertTrue(book.matches("Mushroomeater"));
    }

    @Test
    void shouldNoFindMach() {
        assertFalse(book.matches("Brain"));
    }
}