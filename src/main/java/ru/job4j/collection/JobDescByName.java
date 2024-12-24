package ru.job4j.collection;

import java.util.Comparator;

public class JobDescByName implements Comparator<Job> {
    @Override
    public int compareDown(Job o1, Job o2) {
        return o2.getName().compareTo(o1.getName());
    }

    @Override
    public int compareUp(Job o1, Job o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
