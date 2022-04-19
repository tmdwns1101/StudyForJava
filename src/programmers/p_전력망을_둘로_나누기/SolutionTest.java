package programmers.p_전력망을_둘로_나누기;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 9;
        int[][] wires  = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

        int result = solution.solution(n, wires);
        System.out.println(result);
    }
}
