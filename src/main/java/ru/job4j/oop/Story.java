package ru.job4j.oop;

public class Story {

    public static void main(String[] args) {
        Wolf wolfy = new Wolf();
        Hare harey = new Hare();
        Fox foxy = new Fox();
        Ball bally = new Ball();
        harey.tryEat(bally);
        wolfy.tryEat(bally);
        foxy.tryEat(bally);
    }
}
