package ru.job4j.collection;

import java.util.Comparator;

/* Сравнение слов по символам */

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        for (int i = 0, j = 0; i < left.length(); i++) {
            if (left.charAt(i) != right.charAt(j)) {
                result = Character.compare(left.charAt(i), right.charAt(j));
                break;
            } else {
                if (result == 0 && left.length() != right.length()) {
                    result = Integer.compare(left.length(), right.length());
                }
            }
            j++;
        }
        return result;
    }
}
