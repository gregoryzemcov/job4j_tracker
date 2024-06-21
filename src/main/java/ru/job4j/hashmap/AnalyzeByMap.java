package ru.job4j.hashmap;

import java.util.*;

import static java.util.Comparator.naturalOrder;

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
        return List.of();
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
        return null;
    }
}
