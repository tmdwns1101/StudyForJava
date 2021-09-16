package programmers.sortedboxer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<Integer> solution(int[] weights, String[] head2head) {

        List<Boxer> boxers = new ArrayList<>();
        for (int i=0; i< head2head.length; i++) {
            int totalWin = 0;
            int totalLose = 0;
            int winCountThanHeavy = 0;
            int myWeight = weights[i];

            char[] scores = head2head[i].toCharArray();
            for (int j = 0; j < scores.length; j++) {
                char score = scores[j];
                if(score == 'L') totalLose++;
                else if(score == 'W') {
                    if(weights[j] > myWeight) winCountThanHeavy++;
                    totalWin++;
                }
            }
            double winningRate = (totalWin+totalLose) > 0 ? (double) totalWin / (totalWin+totalLose) : 0;
            Boxer boxer = new Boxer(i+1, myWeight,winningRate,winCountThanHeavy);
            boxers.add(boxer);
        }

        return boxers.stream().sorted((boxer2, boxer1) -> {
            if(boxer1.winningRate != boxer2.winningRate) return Double.compare(boxer1.winningRate, boxer2.winningRate);
            else if(boxer1.winCountThanHeavy != boxer2.winCountThanHeavy) return Integer.compare(boxer1.winCountThanHeavy, boxer2.winCountThanHeavy);
            else if(boxer1.weight != boxer2.weight) return Integer.compare(boxer1.weight,boxer2.weight);
            else return Integer.compare(boxer2.number, boxer1.number);
        }).map(boxer -> boxer.number).collect(Collectors.toList());



    }

    private static class Boxer {
        int number;
        int weight;
        double winningRate;
        int winCountThanHeavy;

        Boxer(int number, int weight, double winningRate, int winCountThanHeavy) {
            this.number = number;
            this.weight = weight;
            this.winningRate = winningRate;
            this.winCountThanHeavy = winCountThanHeavy;
        }
     }
}
