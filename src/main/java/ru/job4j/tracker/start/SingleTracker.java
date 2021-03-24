package ru.job4j.tracker.start;
import ru.job4j.tracker.models.Item;

import java.util.Arrays;

public class SingleTracker {
	private Tracker tracker = new Tracker();
	private static SingleTracker instance = null;
    private SingleTracker() {}
	public static SingleTracker getInstance() {
		if (instance == null) {
			instance = new SingleTracker();
		}
		return instance;
	}
	public Item add(Item item){
		return tracker.add(item);
	}
	public Item replace(String id, Item item) {
		return tracker.replace(id, item);
	}
	public Item delete(String id) {
		return tracker.delete(id);
	}
	public Item findAll() {
		return tracker.findAll(items);
	}
	public Item[] findByName(String key) {
		return tracker.findByName(items);
	}
	public Item findById(String id) {
		return findById(id);
	}
}
