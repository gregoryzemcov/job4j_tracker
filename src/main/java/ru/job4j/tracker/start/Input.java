package ru.job4j.tracker.start;
/**
 * Интерфейс ввода данных Input.
 * @author Gregory Zemtsov (griffondark@gmail.com).
 * @version $Id$.
 * @since 19.12.2019.
 */
public interface Input {
    String askStr(String question);
    int askInt(String question);
}
