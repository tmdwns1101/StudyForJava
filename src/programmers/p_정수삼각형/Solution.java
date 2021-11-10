package programmers.p_정수삼각형;

import java.util.stream.IntStream;

public class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n+1][n+2];

        for(int i=1; i<=triangle.length; i++){
            for(int j=1; j<=triangle[i-1].length; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + triangle[i-1][j-1];
            }
        }
        return IntStream.of(dp[n]).max().orElse(-1);
    }
}
