package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng) {
        String answer = "Неизвестное слово " + eng;
        return answer;
    }

    public static void main(String[] args) {
        DummyDic dic = new DummyDic();
        System.out.println(dic.engToRus("answer"));
    }
}
