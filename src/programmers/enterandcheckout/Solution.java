package programmers.enterandcheckout;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[] solution(int[] enter, int[] leave) {
        int n = enter.length;
        int[] answer = new int[n];

        List<Integer> list = new LinkedList<>();

        int j = 0;
        int i = 0;
        while (i < n && j < n) {
            if(!list.contains(leave[j])) {
                list.add(enter[i]);
                i++;
            } else {
                list.remove(Integer.valueOf(leave[j]));
                for(int number: list){
                  answer[number-1] += 1;
                  answer[leave[j]-1] += 1;
                }
                j++;
            }
        }
        for(int number: list) {
            answer[number-1] += list.size()-1;
        }
        return answer;
    }
}
