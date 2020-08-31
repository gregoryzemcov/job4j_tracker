package ru.job4j.tracker.start;
import ru.job4j.tracker.models.*;
/**
 * Класс поиска всех заявок через иетерфейс UserAction.
 * @author Gregory Zemtsov (griffondark@gmail.com).
 * @version $Id$.
 * @since 17.02.2020.
 */
public class FindAllAction implements UserAction {
    private Output output;
    public FindAllAction (Output output) {
        this.output = output;
    }
    @Override
    public String name() {
        return "== Show all items ==";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        for (Item item : tracker.findAll()) {
			output.println(String.format("%s %s", item.getId(), item.getName()));
		}
        return true;
    }
}
