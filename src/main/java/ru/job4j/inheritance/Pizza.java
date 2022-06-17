package ru.job4j.inheritance;

public class Pizza {
    private final int weight;

    public Pizza(int weight) {
        this.weight = weight;
    }

    public String name() {
        return "Just tasty pizza";
    }

    public int price() {
        return weight * 100;
    }
}
