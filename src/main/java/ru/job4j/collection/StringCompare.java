package ru.job4j.collection;

import java.util.Comparator;

/* Сравнение слов по символам */

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        for (int i = 0, j = 0; i < left.length(); i++) {
            if (Integer.compare(left.charAt(i), right.charAt(j)) == 0) {
                result = Character.compare(left.charAt(i), right.charAt(j));
            }
            j++;
        }
        return result;
    }
}
