package ru.job4j.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ScheduleTask {
    private PriorityQueue<Task> queue;

    public ScheduleTask(Comparator<Task> comparator) {
        this.queue = new PriorityQueue<>(comparator);
    }

    public void addTask(Task task) {
        Position position;
        String description = new String();
        int urgency = Integer.parseInt(new String());
    }

    public Task readTask() {
        return null;
    }

    public Task getTask() {
        return null;
    }
}
