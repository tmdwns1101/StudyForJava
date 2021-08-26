package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem3 {
    public int solution(String word, String[] cards) {
        int answer = 0;
        int[][] array = new int[cards.length][cards.length];
        for (int[] row : array) {
            Arrays.fill(row, -1);
        }

        while(true) {
            Set<Integer> bannedRow = new HashSet<>();
            Set<Integer> bannedCol = new HashSet<>();
            String currentString = word;

            for(int i=0; i< cards.length; i++) {
                if(!bannedRow.contains(i)){
                    for(int j=0; j<cards.length; j++) {
                        if(!bannedCol.contains(j)){
                            if( word.indexOf(cards[i].charAt(j)) != -1 && array[i][j] == -1) {
                                currentString = currentString.replace(Character.toString(cards[i].charAt(j)) , "");
                                array[i][j] = answer;
                                bannedRow.add(i);
                                bannedCol.add(j);
                            }
                        }
                    }
                }
            }

            if(currentString.length() == 0) answer += 1;
            else break;
        }

        return answer;
    }
}
