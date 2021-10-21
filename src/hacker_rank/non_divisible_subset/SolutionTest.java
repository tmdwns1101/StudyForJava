package hacker_rank.non_divisible_subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 4;
        List<Integer> s = new ArrayList<>(Arrays.asList(19, 10, 12, 10, 24, 25, 22));
        int res = solution.nonDivisibleSubset(k, s);
        System.out.println("res = " + res);
    }
}
