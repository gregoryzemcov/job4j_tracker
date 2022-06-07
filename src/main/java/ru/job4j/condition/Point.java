package ru.job4j.condition;

public class Point {
    private int x;
    private int y;

    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    public double distance(Point that) {
        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
    }

    public static void main(String[] args) {
        Point a = new Point(1, 2);
        Point b = new Point(3, 4);
        double result = a.distance(b);
        System.out.println("result (0, 0) to (2, 0) " + result);
    }
}
