package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    HashSet<String> result = new HashSet<>();

    public List extractNumber(List<Task> tasks) {
        for (Task s : tasks) {
            result.add(String.valueOf(s.getNumber()));
        }
        return List.copyOf(result);
    }
}
