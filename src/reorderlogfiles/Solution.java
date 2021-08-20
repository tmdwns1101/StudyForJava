package reorderlogfiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        String[] input = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] result = solution(input);
        System.out.println(Arrays.toString(result));
    }

    public static String[] solution(String[] logs) {

        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        for(String log: logs) {
            if( Character.isDigit(log.split(" ")[1].toCharArray()[0])){
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }
        String[] answer = new String[letterLogs.size()+digitLogs.size()];
        List<String> sortedLetterLogs = letterLogs.stream().sorted((s1, s2) -> {
            String[] sArr1 = s1.split(" ",2);
            String[] sArr2 = s2.split(" ",2);
            int compRes = sArr1[1].compareTo(sArr2[1]);
            if(compRes == 0){
                return sArr1[0].compareTo(sArr2[0]);
            }
            return compRes;
        }).collect(Collectors.toList());
        int i = 0;
        for(String log: sortedLetterLogs) {
            answer[i++] = log;
        }
        for(String log: digitLogs) {
            answer[i++] = log;
        }
        return answer;
    }
}
