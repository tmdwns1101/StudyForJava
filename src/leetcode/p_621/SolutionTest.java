package leetcode.p_621;

public class SolutionTest {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        Solution solution = new Solution();
        int result = solution.leastInterval(tasks,2);
        System.out.println("result = " + result);
    }
}
