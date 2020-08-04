package ru.job4j.io;
import java.util.Random;
import java.util.Scanner;

public class MagicBall {
	private String answer;
	public MagicBall() {}
	public String answer(int count) {
		if (count == 0) {
			answer = "Да.";
		} else if (count == 1) {
			answer = "Нет.";
		} else {
			answer = "Может быть.";
		}
		return answer;
	}
    public static void main(String[] args) {
		int count = new Random().nextInt(3);
		MagicBall magic = new MagicBall();
        Scanner input = new Scanner(System.in);
        System.out.println("Я великий Оракул. Что ты хочешь узнать? ");
        String question = input.nextLine();
        System.out.println(question);
		System.out.println(magic.answer(count));
    }
}