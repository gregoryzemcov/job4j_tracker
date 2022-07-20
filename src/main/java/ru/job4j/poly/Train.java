package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " speed: 200 km/hour");
    }

    @Override
    public int passInt(int pass) {
        return pass;
    }
}
