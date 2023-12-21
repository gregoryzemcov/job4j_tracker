package ru.job4j.list;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class ConvertMatrix2ListTest {
    /**
     * Тест класса ConvertMatrix2List "Конвертация массива int[][] в список ArrayList".
     * @author Gregory Zemtsov (griffondark@gmail.com).
     * @since 20.12.2023.
     */
    @Test public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        List<Integer> result = list.toList(input);
        assertThat(result).containsAll(expected);
    }
}
