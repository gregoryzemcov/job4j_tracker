package ru.job4j.tracker;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import ru.job4j.tracker.start.*;
import ru.job4j.tracker.models.*;
/**
 * Тест проверки класса StartUI.
 * @author Gregory Zemtsov (griffondark@gmail.com).
 * @version $Id$.
 * @since 24.12.2019.
 */
public class StartUITest {
    @Test
    public void whenExit() {
		Output out = new StubOutput();
        Input input = new StubInput(new String[] {"0"});
        Tracker tracker = new Tracker();
        UserAction[] action = { new ExitAction() };
        new StartUI(out).init(input, tracker, action);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "0. Exit" + System.lineSeparator()));
    }
	@Test
	public void whenPrtMenu() {
		//ByteArrayOutputStream out = new ByteArrayOutputStream();
		//PrintStream def = System.out;
		//System.setOut(new PrintStream(out));
		StubInput input = new StubInput(new String[] {"0"});
		StubAction action = new StubAction();
		Output output = new StubOutput();
		new StartUI(output).init(input, new Tracker(), new UserAction[] {action});
		String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
				.add("Menu.")
				.add("0. Stub action")
				.toString();
		assertThat(new String(output.toString()), is(expect));
		//System.setOut(def);
	}
	@Test
	public void whenCreateItem() {
		Input in = new StubInput(new String[] {"0", "Item name", "1"});
		Output output = new StubOutput() {
            @Override
            public void println(Object obj) { }
        };
		Tracker tracker = new Tracker();
		UserAction[] actions = { new CreateAction(output), new ExitAction() };
		new StartUI(output).init(in, tracker, actions);
		assertThat(tracker.findAll()[0].getName(), is("Item name"));
	}
    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput() {
            @Override
            public void println(Object obj) { }
        };
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", item.getId(), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                new String[] {"0", item.getId(), "1"}
        );
        Output output = new StubOutput();
        UserAction[] actions = {
                new DeleteAction(),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
}
