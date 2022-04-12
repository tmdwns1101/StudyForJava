package programmers.p_가장_큰_정사각형_찾기;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] board = {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };

        int result = solution.solution(board);
        System.out.println(result);
    }
}
