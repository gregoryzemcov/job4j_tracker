package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    public static List<Item> items = new ArrayList<>();

    private int size = 0;

    public Item add(Item item) {
        items.add(item);
        return items.get(item.getId());
    }

    public Item findById(int id) {
        return indexOf(id) != -1 ? items.get(indexOf(id)) : null;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public Item[] findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                rsl.add(item);
            }
        }
        return rsl.toArray(new Item[0]);
    }

    public boolean replace(int id, Item item) {
        boolean rsl = indexOf(id) != -1;
        if (rsl) {
            item.setId(id);
        }
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean delete(int id) {
        boolean rsl = indexOf(id) != -1;
        if (rsl) {
            items.remove(indexOf(id));
        }
        return rsl;
    }
}