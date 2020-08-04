package ru.job4j.poly;

public interface Transport {
    String go();
    void pass(int passengers);
    int pay(int fuel);
}
