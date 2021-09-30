package programmers.enterandcheckout;

import java.util.Arrays;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] enter = {1, 4, 2, 3};
        int[] leave ={2, 1, 4, 3};
        int[] result = solution.solution(enter, leave);
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
    }
}
