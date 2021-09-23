package programmers.quadcompression;

import java.util.Arrays;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr ={
                {1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}
        };
        int[] result = solution.solution(arr);
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
    }
}
