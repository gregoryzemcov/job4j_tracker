package ru.job4j.oop;

public class Error {

    boolean active;
    int status;
    String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Ошибка: " + active);
        System.out.println("Номер ошибки: " + status);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error err = new Error();
        err.printInfo();
        Error error = new Error(true, 1, "Начало.");
        error.printInfo();
    }
}
