package ru.job4j.tracker.start;
import ru.job4j.tracker.models.Item;
//import java.util.Arrays;

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
	public boolean replace(String id, Item item) {
		return tracker.replace(id, item);
	}
	public boolean delete(String id) {
		return tracker.delete(id);
	}
	public Item[] findAll() {
		return tracker.findAll();
	}
	public Item[] findByName(String key) {
		return tracker.findByName(key);
	}
	public Item findById(String id) {
		return findById(id);
	}
}
