package ru.job4j.pojo;

public class Book {
    private String name;
    private int list;

    public Book(String name, int list) {
        this.name = name;
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getList() {
        return list;
    }

    public void setList(int list) {
        this.list = list;
    }
}
