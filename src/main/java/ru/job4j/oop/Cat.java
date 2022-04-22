package ru.job4j.oop;

public class Cat {
    private String food;
    private String name;

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void show() {
        System.out.println("Cat " + this.name + " eats " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void voice(String mau) {
        System.out.println(mau);
    }

    public static void main(String[] args) {
        Cat peppy = new Cat();
        Cat sparky = new Cat();
        String mau = "Мяу";
        peppy.giveNick("Pep");
        peppy.eat("fish");
        peppy.show();
        sparky.giveNick("Spark");
        sparky.eat("cutlet");
        sparky.show();
        sparky.voice(mau);

    }
}
