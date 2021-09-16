package programmers.lessthantwodifferentbeats;

import java.util.Arrays;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long[] numbers = {2,7};
        long[] result = solution.solution(numbers);
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
    }
}
