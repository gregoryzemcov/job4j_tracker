package ru.job4j.oop;

public class Wolf {

    String name = "Волк";

    public void tryEat(Ball ball) {
        System.out.println(name + ": Колобок, колобок я тебя съем.");
        ball.tryRun(false);
    }

}
