package programmers.p_특별모의고사.p1;

import java.util.Arrays;

public class Solution {
    public int solution(int[] people, int[] tshirts) {
        int answer = 0;
        Arrays.sort(people);
        Arrays.sort(tshirts);
        int j = tshirts.length-1;
        for(int i=people.length-1; i>=0; i--) {
            if(j >= 0 && people[i] <= tshirts[j]) {
                answer++;
                j--;
            }
        }
        return answer;
    }
}
