package ru.job4j.tracker;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import ru.job4j.tracker.start.*;
import ru.job4j.tracker.models.*;
/**
 * Тест проверки класса FindAllAction.
 * @author Gregory Zemtsov (griffondark@gmail.com).
 * @version $Id$.
 * @since 02.04.2020.
 */
public class FindAllActionTest {
    @Test
    public void whenCheckOutput() {
        //ByteArrayOutputStream out = new ByteArrayOutputStream();
        //PrintStream def = System.out;
        //System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Item item = new Item("fix bug");
        tracker.add(item);
        FindAllAction act = new FindAllAction(output);
        act.execute(new StubInput(new String[] {}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add(item.getId() + " " + item.getName())
                .toString();
        assertThat(output.toString(), is(expect));
        //System.setOut(def);
    }
}
