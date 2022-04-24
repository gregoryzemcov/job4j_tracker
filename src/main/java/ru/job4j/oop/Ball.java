package ru.job4j.oop;

public class Ball {

    String name = "Колобок";

    public void tryRun(boolean condition) {
        if (condition) {
            System.out.println(name + " съеден.");
        } else {
            System.out.println(name + " сбежал.");
        }
    }

}
