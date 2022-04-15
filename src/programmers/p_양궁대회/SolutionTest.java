package programmers.p_양궁대회;

import java.util.Arrays;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 5;
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
        int[] result = solution.solution(n,info);
        System.out.println(Arrays.toString(result));
    }
}
