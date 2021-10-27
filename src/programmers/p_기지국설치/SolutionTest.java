package programmers.p_기지국설치;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 16;
        int[] stations = {9};
        int w = 2;
        int result = solution.solution(n, stations, w);
        System.out.println("result = " + result);
    }
}
