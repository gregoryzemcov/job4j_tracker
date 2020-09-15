package ru.job4j.ex;

public class User {
    private String username;
    private boolean valide;
    public User (String username, boolean valide) {
        this.username = username;
        this.valide = valide;
    }
    public String getUsername() {
        return username;
    }
    public boolean isValide() {
        return valide;
    }
}
