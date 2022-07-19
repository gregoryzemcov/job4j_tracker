package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman freshman = new Freshman();
        Student student = freshman;
        Object obj = freshman;
        System.out.println("Ритм freshman: ");
        freshman.music();
        System.out.println("Солист student: ");
        student.music("В каморке, что за актовым залом...");

    }
}
