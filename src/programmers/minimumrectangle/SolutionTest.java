package programmers.minimumrectangle;

public class SolutionTest {
    public static void main(String[] args) {
        int[][] sizes = {
                {60, 50}, {30, 70}, {60, 30}, {80, 40}
        };
        Solution solution = new Solution();
        int result = solution.solution(sizes);
        System.out.println("result = " + result);
    }
}
