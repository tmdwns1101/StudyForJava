package weeklychallenge4;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] languages = {"PYTHON", "C++", "SQL"};
        int[] preference = {7,5,5};
        String result = solution(table,languages,preference);
        System.out.println("result = " + result);
    }

    public static String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";

        int maxScore = 0;

        for(String row: table) {
            int score = 0;
            String[] cells = row.split(" ");
            String occupation = cells[0];
            String[] occupationPreferLanguages = Arrays.copyOfRange(cells, 1, cells.length);

            for(int i=0; i<languages.length; i++) {
                String language = languages[i];
                for(int j =0; j<occupationPreferLanguages.length; j++) {
                    if(language.equals(occupationPreferLanguages[j])) {
                        score += preference[i] * (5-j);
                    }
                }
            }
            if(maxScore < score) {
                maxScore = score;
                answer = occupation;
            } else if (maxScore == score) {
                answer = answer.compareTo(occupation) < 0 ? answer : occupation;
            }
        }

        return answer;
    }
}
