package ru.job4j.tracker.start;
/**
 * Класс поиска заявки по Id через иетерфейс UserAction.
 * @author Gregory Zemtsov (griffondark@gmail.com).
 * @version $Id$.
 * @since 17.02.2020.
 */
public class FindByIdAction implements UserAction {
    private final Output out;
    public FindByIdAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "== Find item by Id ==";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("Enter id: ");
        String id = input.askStr(" ");
        tracker.findById(id);
        return true;
    }
}
