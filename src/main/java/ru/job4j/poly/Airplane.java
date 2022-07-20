package ru.job4j.poly;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " speed: 850 km/hour");
    }

    @Override
    public int passInt(int pass) {
        return pass;
    }
}
