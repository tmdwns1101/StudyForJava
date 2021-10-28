package programmers.p_예산;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] budgets = {120, 110, 140, 150};
        int M = 485;
        int result = solution.solution(budgets,M);
        System.out.println("result = " + result);
    }
}
