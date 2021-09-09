package monthlychallenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public int solution(int[] numbers) {
        int answer = 0;
        int[] allNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        Set<Integer> set = new HashSet<>();
        for(int n : numbers) set.add(n);

        for(int number: allNumbers) {
            if(!set.contains(number)) answer += number;
        }
        return answer;
    }
}
