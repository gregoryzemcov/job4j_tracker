package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {
    private static final int CHEESE_PRICE = 30;

    public PizzaExtraCheese(int weight) {
        super(weight);
    }

    @Override
    public String name() {
        return "Just tasty pizza with cheese";
    }

    @Override
    public int price() {
        return CHEESE_PRICE + super.price();
    }
}
