package ru.job4j.oop;

public class Cat {
    public void voice2() {
        System.out.println("Big Mau");
    }

    public void voice() {
        System.out.println("Mau");
    }

    public static void main(String[] args) {
        Cat peppy = new Cat();
        Cat sparky = new Cat();
        peppy.voice();
        sparky.voice2();
    }
}
