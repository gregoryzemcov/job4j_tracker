package ru.job4j.tracker.start;
import java.util.Scanner;
/**
 * Класс итерфейса Input - ConsoleInput.
 * @author Gregory Zemtsov (griffondark@gmail.com).
 * @version $Id$.
 * @since 19.10.2019.
 */
public class ConsoleInput implements Input {
	private final Output output;
	private Scanner scanner = new Scanner(System.in);
	public ConsoleInput(Output output) {
		this.output = output;
	}
	@Override
	public String askStr(String question) {
		output.println(question);
		return scanner.nextLine();
	}
	@Override
	public int askInt(String question) {
		return Integer.parseInt(askStr(question));
	}
}
