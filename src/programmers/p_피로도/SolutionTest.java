package programmers.p_피로도;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int k = 80;

        int[][] dungeons = {
                {80,20},{50,40},{30,10}
        };
        int result = solution.solution(k,dungeons);
        System.out.println(result);
    }
}
