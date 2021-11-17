package programmers.p_빛의_경로_사이클;

import java.util.Arrays;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] grid = {"R", "R"};
        int[] result = solution.solution(grid);
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
    }
}
