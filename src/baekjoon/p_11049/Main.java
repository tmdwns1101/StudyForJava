package baekjoon.p_11049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] matrix;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        matrix = new int[n][2];
        dp = new int[n][n];
        for(int[] item: dp) {
            Arrays.fill(item, Integer.MAX_VALUE);
        }
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        int answer = divide(0,n-1);
        System.out.println(answer);
    }

    public static int divide(int s, int e) {
        if(s == e) return 0;
        if(dp[s][e] != Integer.MAX_VALUE) {
            return dp[s][e];
        }
        for(int i=s; i<e; i++) {
            int result = divide(s,i) + divide(i+1,e) + matrix[s][0]*matrix[i][1]*matrix[e][1];
            dp[s][e] = Math.min(result, dp[s][e]);
        }
        return dp[s][e];
    }
}
