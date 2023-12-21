package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    /**
     * Класс "Конвертация массива int[][] в список ArrayList".
     * @author Gregory Zemtsov (griffondark@gmail.com).
     * @since 20.12.2023.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : array) {
            for (int cell : row) {
                list.add(cell);
            }
        }
        return list;
    }
}
