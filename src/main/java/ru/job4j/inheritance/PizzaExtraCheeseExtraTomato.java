package ru.job4j.inheritance;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    private static final int CHEESE_TOMATO_PRICE = 50;

    public PizzaExtraCheeseExtraTomato(int weight) {
        super(weight);
    }

    @Override
    public String name() {
        return "Just tasty pizza with cheese and tomato";
    }

    @Override
    public int price() {
        return CHEESE_TOMATO_PRICE + super.price();
    }
}
