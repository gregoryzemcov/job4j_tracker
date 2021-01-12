package ru.job4j.tracker.start;
import ru.job4j.tracker.models.*;
/**
 * Класс интерфейса StartUI.
 * @author Gregory Zemtsov (griffondark@gmail.com).
 * @version $Id$.
 * @since 19.10.2019.
 */
public class StartUI {
	private final Output out;
	public StartUI(Output out) {
		this.out = out;
	}
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.length) {
                out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
                continue;
            }
            UserAction action = actions[select];
			run = action.execute(input, tracker);
        }
    }
    private void showMenu(UserAction[] actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
			out.println(index + ". " + actions[index].name());
		}        
    }	
    public static void main(String[] args) {
		Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput(output));
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(output), new ExitAction(), new ReplaceAction(output)};
        new StartUI(output).init(input, tracker, actions);
    }
}