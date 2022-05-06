package ru.job4j.oop;
/**
 *  Статические методы и поля в классе.
 */
public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int b) {
        return b - x;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int d) {
        return sum(d) + multiply(d) + minus(d) + divide(d);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int rslSum = sum(10);
        int rslMultiple = calc.multiply(5);
        int rslMinus = minus(7);
        int rslDivide = calc.divide(25);
        int rsl = calc.sumAllOperation(5);
        System.out.println(rslSum);
        System.out.println(rslMultiple);
        System.out.println(rslMinus);
        System.out.println(rslDivide);
        System.out.println(rsl);
    }
}
