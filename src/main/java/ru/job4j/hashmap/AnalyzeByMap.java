package ru.job4j.hashmap;

import java.util.*;

/** Класс определяет:
 * Общий средний балл averageScore
 * Средний балл по каждому ученику averageScoreByPupil
 * Средний балл по каждому предмету averageScoreBySubject
 * Лучшего ученика с наибольшим суммарным баллом по всем предметам bestStudent
 * Предмет с наибольшим баллом для всех студентов bestSubject
 */
public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double result = 0.0, resultScore;
        int number = 0;
        List<Label> pupilScore = averageScoreByPupil(pupils);
        for (Label lab : pupilScore) {
            result += lab.score();
            number++;
        }
        resultScore = result / number;
        return resultScore;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> lab = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double result = 0.0, resultScore;
            int number = 0;
            for (Subject sub : pupil.subjects()) {
                double res = sub.score();
                result += res;
                number++;
            }
            resultScore = result / number;
            Label pupilScore = new Label(pupil.name(), resultScore);
            lab.add(pupilScore);
        }
        return lab;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        int number = 0, result;
        for (Pupil pupil : pupils) {
            for (Subject sub : pupil.subjects()) {
                int var = 0;
                String name = sub.name();
                for (Map.Entry<String, Integer> m : map.entrySet()) {
                    if (m.getKey().equals(sub.name())) {
                        var = m.getValue();
                    }
                }
                result = var + sub.score();
                map.put(name, result);
            }
            number++;
        }
        List<Label> lab = new ArrayList<>();
        for (Map.Entry<String, Integer> m : map.entrySet()) {
                int var = m.getValue() / number;
                Label subScore = new Label(m.getKey(), var);
                lab.add(subScore);
        }
        return lab;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> lab = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double result = 0.0;
            for (Subject sub : pupil.subjects()) {
                double res = sub.score();
                result += res;
            }
            Label pupilScore = new Label(pupil.name(), result);
            lab.add(pupilScore);
        }
        lab.sort(Comparator.naturalOrder());
        return lab.get(pupils.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        int result;
        for (Pupil pupil : pupils) {
            for (Subject sub : pupil.subjects()) {
                int var = 0;
                String name = sub.name();
                for (Map.Entry<String, Integer> m : map.entrySet()) {
                    if (m.getKey().equals(sub.name())) {
                        var = m.getValue();
                    }
                }
                result = var + sub.score();
                map.put(name, result);
            }
        }
        List<Label> lab = new ArrayList<>();
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            int var = m.getValue();
            Label subScore = new Label(m.getKey(), var);
            lab.add(subScore);
        }
        lab.sort(Comparator.naturalOrder());
        return lab.get(pupils.size() - 1);
    }
}
