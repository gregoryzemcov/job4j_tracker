package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public String go() {
        return null;
    }
    @Override
    public void pass(int passengers) { }
    @Override
    public int pay(int fuel) {
        int coast = 45;
        int pay = fuel * coast;
        return pay;
    }
}
