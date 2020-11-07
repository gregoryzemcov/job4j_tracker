package ru.job4j.tracker;
import org.junit.Test;
import ru.job4j.tracker.start.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
public class ValidateInputTest {
    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput( new String[] {"one", "1"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        String output = String.format("Enter menu:%n" + "Please enter validate data again.%n" + "Enter menu:");
        assertThat(output.toString(), is(output));
        assertThat(selected, is(1));
    }
}
