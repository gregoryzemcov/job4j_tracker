package ru.job4j.tracker.start;
import ru.job4j.tracker.models.Item;
/**
 * Класс создания заявки через иетерфейс UserAction.
 * @author Gregory Zemtsov (griffondark@gmail.com).
 * @version $Id$.
 * @since 17.02.2020.
 */
public class CreateAction implements UserAction {
	private final Output out;
	public CreateAction(Output out) {
		this.out = out;
	}
    @Override
    public String name() {
        return "Create";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.print("== Create a new Item ==");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        return true;
    }
}
