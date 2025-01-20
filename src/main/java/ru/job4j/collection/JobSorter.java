package ru.job4j.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        Comparator<Job> combine = new JobDescByNameLength()
                .thenComparing(new JobDescByNameUp())
                .thenComparing(new JobDescByPriorityUp());
        jobs.sort(combine);
        System.out.println(jobs);
    }
}