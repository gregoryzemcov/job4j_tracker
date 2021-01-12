package ru.job4j.tracker.start;
import ru.job4j.tracker.models.Item;
public enum TrackerSingle {
    INSTANCE;
    public Item add(Item model) {
        return model;
    }
}
