package ru.job4j.tracker.start;
import ru.job4j.tracker.models.Item;
/**
 * Класс редактирования заявки через интерфейс UserAction.
 * @author Gregory Zemtsov (griffondark@gmail.com).
 * @version $Id$.
 * @since 17.02.2020.
 */
public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Enter name: ";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.print("Enter id: ");
        String id = input.askStr(" ");
        String name = input.askStr("");
        Item item = new Item();
        item.setName(name);
        tracker.replace(id, item);
        return true;
    }
}
