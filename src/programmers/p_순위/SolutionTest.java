package programmers.p_순위;

public class SolutionTest {
    public static void main(String[] args) {
        int n = 4;
        //int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        int[][] results = {{1, 2}, {2, 3}, {1, 4}};
        
        Solution solution = new Solution();
        int ans = solution.solution(n,results);
        System.out.println("ans = " + ans);
    }
}
