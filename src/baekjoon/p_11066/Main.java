package baekjoon.p_11066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    private static final int MAX_RANGE = 501;
    private static int[] costs = new int[MAX_RANGE];
    private static int[] sum = new int[MAX_RANGE];
    private static int[][] dp = new int[MAX_RANGE][MAX_RANGE];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());



        for(int t=0; t<testCase; t++) {

            for(int i=1; i<MAX_RANGE; i++) {
                for(int j=1; j<MAX_RANGE; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }

            int k = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=k; i++) {
                int cost = Integer.parseInt(st.nextToken());
                costs[i] = cost;
                sum[i] = sum[i-1] + costs[i];
            }
            int answer = solution(1,k);
            System.out.println(answer);
        }
    }

    public static int solution(int start, int end) {
       if(dp[start][end] != Integer.MAX_VALUE) {
           return dp[start][end];
       }
       if(start == end) {
           return dp[start][end] = 0;
       }
       if(start + 1 == end) {
           return dp[start][end] = costs[start] + costs[end];
       }

       for(int mid=start; mid<end; mid++) {
           int left = solution(start,mid);
           int right = solution(mid+1, end);
           dp[start][end] = Math.min(dp[start][end], left+right);
       }

       return dp[start][end] += sum[end] - sum[start-1];
    }



}
