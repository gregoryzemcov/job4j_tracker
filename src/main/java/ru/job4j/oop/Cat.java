package ru.job4j.oop;

public class Cat {

    public void voice(String mau) {
        System.out.println(mau);
    }

    public static void main(String[] args) {
        Cat peppy = new Cat();
        Cat sparky = new Cat();
        String mau = "Mau";
        String bigMau = "Big Mau";
        peppy.voice(mau);
        sparky.voice(bigMau);
    }
}
