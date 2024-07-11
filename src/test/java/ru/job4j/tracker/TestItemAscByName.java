package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class TestItemAscByName {
    @Test
    public void whenItemAscByName() {
        List<Item> items = Arrays.asList(
                new Item(1, "Pavel"),
                new Item(2, "Viktor"),
                new Item(3, "Daniil")
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(3, "Daniil"),
                new Item(1, "Pavel"),
                new Item(2, "Viktor")
        );
        assertEquals(items, expected);
    }
}
