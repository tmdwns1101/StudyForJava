package programmers.kakaofriendscolor;

import java.util.Arrays;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] picture = {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};
        int[] result = solution.solution(5,4,picture);
        System.out.println("result.toString() = " + Arrays.toString(result));
    }
}
