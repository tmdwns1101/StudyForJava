package programmers.p_정수삼각형;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };
        int res = solution.solution(triangle);
        System.out.println("res = " + res);
    }
}
