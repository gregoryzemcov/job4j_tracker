package ru.job4j.tracker;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
import java.util.StringJoiner;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
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
		assertThat(output.toString(), is(expect));
		//System.setOut(def);
	}
	@Test
	public void whenCreateItem() {
		Input in = new StubInput(new String[] {"0", "Item name", "1"});
		Output output = new StubOutput();
		Tracker tracker = new Tracker();
		UserAction[] actions = { new CreateAction(output), new ExitAction() };
		new StartUI(output).init(in, tracker, actions);
		assertThat(tracker.findAll()[0].getName(), is("Item name"));
	}
    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
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
    @Test
    public void whenFindAllItems() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Item[] items = {
                tracker.add(new Item("item 1")),
                tracker.add(new Item(null)),
                tracker.add(new Item("item 2")),
                tracker.add(new Item(null))
        };
        Input input = new StubInput(new String[] {"0", "1"});
        UserAction[] actions = {
                new FindAllAction(output),
                new ExitAction()
        };
        StringJoiner expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator());
        expect.add("Menu.");
        expect.add("0. == Show all items ==");
        expect.add("1. Exit");
        expect.add(String.format("%s %s", items[0].getId(), items[0].getName()));
        expect.add(String.format("%s %s", items[1].getId(), items[1].getName()));
        expect.add(String.format("%s %s", items[2].getId(), items[2].getName()));
        expect.add(String.format("%s %s", items[3].getId(), items[3].getName()));
        expect.add("Menu.");
        expect.add("0. == Show all items ==");
        expect.add("1. Exit");
        new StartUI(output).init(input, tracker, actions);
        assertEquals(expect.toString(), output.toString());
    }
    @Test
    public void whenFindByIdItems() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Item item1 = new Item("item 1");
        Item item2 = new Item("item 2");
        tracker.add(item1);
        tracker.add(item2);
        Input input = new StubInput(new String[] {"0", item2.getId(), "1"});
        UserAction[] actions = {
                new FindByIdAction(),
                new ExitAction()
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item2.getId()), is(item2));
    }
    @Test
    public void whenFindByNameItems() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Item[] items = {
                tracker.add(new Item("item 1")),
                tracker.add(new Item("item 2")),
                tracker.add(new Item("item 3")),
                tracker.add(new Item("item 1"))
        };
        Input input = new StubInput(new String[] {"0", items.toString(), "1"});
        UserAction[] actions = {
                new FindByNameAction(),
                new ExitAction()
        };
        String key = "item 1";
        Item[] expect = new Item[2];
        expect[0] = items[0];
        expect[1] = items[3];
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findByName(key), is(expect));
    }
    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] { "2", "0"/* Пункты меню: неверный, верный.*/ }
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit%n"
                )
        ));
    }
}
