package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {

    public List<String> extractNumber(List<Task> tasks) {
        HashSet<String> result = new HashSet<>();
        for (Task s : tasks) {
            result.add(String.valueOf(s.getNumber()));
        }
        return List.copyOf(result);
    }
}
