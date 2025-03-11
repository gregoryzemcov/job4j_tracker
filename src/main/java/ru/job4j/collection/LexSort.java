package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;

/*
Сравнение по номеру задачи из строк
@param String
*/

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int l = Integer.parseInt(left.split("\\.")[0]);
        int r = Integer.parseInt(right.split("\\.")[0]);
        return Integer.compare(l, r);
    }
}
