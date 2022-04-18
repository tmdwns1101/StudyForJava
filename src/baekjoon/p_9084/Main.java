package baekjoon.p_9084;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 9084 - 동전
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int t=0; t<testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] coins = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int target = Integer.parseInt(br.readLine());
            int[] dp = new int[target+1];
            dp[0] = 1;

            for(int coin: coins) {
                for(int i=coin; i<=target; i++) {
                    dp[i] += dp[i-coin];
                }
            }
            System.out.println(dp[target]);
        }
    }
}
