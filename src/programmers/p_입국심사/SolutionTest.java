package programmers.p_입국심사;

public class SolutionTest {
    public static void main(String[] args) {
        int n = 3;
        int[] times = {1000000000,999999999};
        Solution solution = new Solution();
        long result = solution.solution(n, times);
        System.out.println("result = " + result);
    }
}
