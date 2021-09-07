package sortedboxer;

import java.util.List;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] weight = {60,70,60};
        String[] head2head = {"NNN","NNN","NNN"};
        List<Integer> result = solution.solution(weight, head2head);
        System.out.println("result.toString() = " + result.toString());
    }
}
