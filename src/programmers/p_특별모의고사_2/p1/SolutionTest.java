package programmers.p_특별모의고사_2.p1;

import java.util.Arrays;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] queries = {
                {3,2},{3,2},{2,2},{3,2},{1,4},{3,2},{2,3},{3,1}
        };
        int[][] result = solution.solution(3,4,2,queries);
        for(int[] it: result) {
            System.out.println(Arrays.toString(it));
        }
    }
}
