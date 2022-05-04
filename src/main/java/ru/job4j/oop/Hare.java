package ru.job4j.oop;

public class Hare {

    private String name = "Заяц";

    public void tryEat(Ball ball) {
        System.out.println(name + ": Колобок, колобок я тебя съем.");
        ball.tryRun(false);
    }

}
