package ru.job4j.inheritance;

public class PizzaShop {
    public static void main(String[] args) {
        Pizza pizza = new Pizza(2);
        PizzaExtraCheese pizzaExtraCheese = new PizzaExtraCheese(3);
        PizzaExtraCheeseExtraTomato pizzaExtraCheeseExtraTomato = new PizzaExtraCheeseExtraTomato(4);
        System.out.println(pizza.name());
        System.out.println(pizza.price());
        System.out.println(pizzaExtraCheese.name());
        System.out.println(pizzaExtraCheese.price());
        System.out.println(pizzaExtraCheeseExtraTomato.name());
        System.out.println(pizzaExtraCheeseExtraTomato.price());
    }
}
