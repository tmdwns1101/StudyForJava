package programmers.rotatingtheborderofthematrix;

import java.util.Arrays;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] queries = {
                {2,2,5,4},
                {3,3,6,6},
                {5,1,6,3}
        };
        int[] result = solution.solution(6,6,queries);
        System.out.println("result = " + Arrays.toString(result));
    }
}
