package ru.job4j.tracker.start;

public class ExitAction implements UserAction {
    @Override
    public String name() {
        return null;
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
