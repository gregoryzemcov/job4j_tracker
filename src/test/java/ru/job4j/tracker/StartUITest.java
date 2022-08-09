package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

/** import org.junit.jupiter.api.Test;
  * import static org.assertj.core.api.Assertions.assertThat;
  */

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    /** @ Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()),
                "edited item"
        };
        Item edited = tracker.findById(item.getId());
        assertThat(edited.getName(), is("edited item"));
    } */

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("item_1");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId())};
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
}
