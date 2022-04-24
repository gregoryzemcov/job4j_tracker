package ru.job4j.oop;

public class Fox {

    String name = "Лис";

    public void tryEat(Ball ball) {
        System.out.println(name + ": Колобок, колобок я тебя съем.");
        ball.tryRun(true);
    }

}
