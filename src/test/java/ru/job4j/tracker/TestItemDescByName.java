package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;

public class TestItemDescByName {
    @Test
    public void whenItemAscByName() {
        List<Item> items = Arrays.asList(
                new Item(1, "Pavel"),
                new Item(2, "Viktor"),
                new Item(3, "Daniil")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(2, "Viktor"),
                new Item(1, "Pavel"),
                new Item(3, "Daniil")
        );
        assertThat(expected, is(items));
    }
}
