package baekjoon.p_5582;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 - 5582
 * 공통 부분 문자열
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];

        int answer = 0;
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(str1.charAt(j-1) == str2.charAt(i-1)) {
                    dp[j][i] = dp[j-1][i-1] + 1;
                    answer = Math.max(answer, dp[j][i]);
                }
            }
        }
        System.out.println(answer);
    }
}
