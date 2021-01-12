package ru.job4j.tracker.start;
import ru.job4j.tracker.models.Item;
/**
 * Класс редактирования заявки через интерфейс UserAction.
 * @author Gregory Zemtsov (griffondark@gmail.com).
 * @version $Id$.
 * @since 17.02.2020.
 */
public class ReplaceAction implements UserAction {
    private final Output out;
    public ReplaceAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Enter name: ";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("Enter id: ");
        String id = input.askStr(" ");
        String name = input.askStr("");
        Item item = new Item();
        item.setName(name);
        tracker.replace(id, item);
        return true;
    }
}
