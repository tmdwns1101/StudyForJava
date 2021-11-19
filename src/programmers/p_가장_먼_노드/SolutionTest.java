package programmers.p_가장_먼_노드;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] edges = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int result = solution.solution(6, edges);
    }
}
