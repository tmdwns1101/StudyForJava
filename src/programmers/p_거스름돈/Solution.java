package programmers.p_거스름돈;

import java.util.Arrays;


public class Solution {

    private final int MOD = 1000000007;

    public int solution(int n, int[] money) {
        int answer = 0;


        Arrays.sort(money);

        int[] dp = new int[n+1];

        dp[0] = 1;
        for(int coin: money) {
            for(int i=coin; i<=n; i++) {
                dp[i] += dp[i-coin] % MOD;
            }
        }

        
        answer = dp[n];
        return answer;
    }
}
