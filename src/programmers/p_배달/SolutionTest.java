package programmers.p_배달;

public class SolutionTest {
    public static void main(String[] args) {
        int n = 5;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int k = 3;
        Solution solution = new Solution();
        int result = solution.solution(n,road,k);
        System.out.println(result);
    }
}
