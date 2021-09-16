package leetcode.dailytemperatures;

import java.util.Arrays;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] result = solution.dailyTemperatures(temperatures);
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
    }
}
