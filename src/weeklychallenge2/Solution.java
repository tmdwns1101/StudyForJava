package weeklychallenge2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        int[][] scores = {{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};
        System.out.println(solution2(scores));
    }
    public static String solution1(int[][] scores) {
        String answer = "";
        List<Integer> grades = new ArrayList<>();
        int size = scores.length;

        for(int j=0;j<size;j++){
            int maxValue = 0;
            int minValue = 100;
            int sumValue = 0;
            int myScore = scores[j][j];
            Map<Integer, Integer> map = new HashMap<>();
            for(int i=0;i<size;i++) {
                int score = scores[i][j];
                maxValue = Math.max(maxValue, score);
                minValue = Math.min(minValue, score);
                if(map.containsKey(score)) {
                    map.put(score, map.get(score) + 1);
                } else {
                    map.put(score, 1);
                }
                sumValue += score;
            }
            if(maxValue == myScore || minValue == myScore ) {
                if(map.get(myScore) == 1) {
                    sumValue -= myScore;
                    grades.add(sumValue / (size-1));
                } else {
                    grades.add(sumValue / size);
                }
            } else {
                grades.add(sumValue / size);
            }
        }

        answer = grades.stream().map(grade -> {
            String gradeAlph = "";
            if(grade >= 90) {
                gradeAlph = "A";
            } else if (grade >= 80) {
                gradeAlph = "B";
            } else if(grade >= 70) {
                gradeAlph = "C";
            } else if (grade >=50) {
                gradeAlph = "D";
            } else {
                gradeAlph = "F";
            }
            return gradeAlph;
        }).collect(Collectors.joining());

        return  answer;

    }

    public static String solution2(int[][] scores) {
        StringBuilder stringBuilder = new StringBuilder();
        int size = scores.length;
        for(int j=0;j<size;j++){
            int maxValue = 0;
            int minValue = 101;
            int sumValue = 0;
            int myScore = scores[j][j];
            int divide = size;

            for(int i=0;i<size;i++) {
                int score = scores[i][j];
                if(i != j) {
                    maxValue = Math.max(maxValue, score);
                    minValue = Math.min(minValue, score);
                }

                sumValue += score;
            }
            if(maxValue < myScore || minValue > myScore ) {
                 sumValue -= myScore;
                 divide--;
            }
            double result = (double) sumValue / divide;
            stringBuilder.append(result >= 90 ? "A" : result >= 80 ? "B" : result >= 70 ? "C" : result >=50 ? "D" :"F");
        }

        return stringBuilder.toString();
    }
}
