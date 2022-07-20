package ru.job4j.poly;

public class Minibus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " speed: 100 km/hour");
    }

    @Override
    public int passInt(int pass) {
        return pass;
    }
}
