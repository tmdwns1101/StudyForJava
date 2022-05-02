package baekjoon.p_2240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 자두나무 - 2240
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] plums = new int[n+1];
        int[][] dp = new int[n+1][w+1];

        for(int i=1; i<=n; i++) {
            plums[i] = Integer.parseInt(br.readLine());
            if(plums[i] == 1) {
                dp[i][0] = dp[i-1][0] + 1;
            } else {
                dp[i][0] = dp[i-1][0];
            }
        }

        /**
         * 1. 움직인 횟수가 짝수 이고, plums[i] = 1 이면, 자두를 받을 수 있다.
         * 2. 움직인 횟수가 홀수 이고, plums[i] = 2 이면, 자두를 받을 수 있다.
         * 3. dp[i-1][j] : 현재 j 만큼 움직였고, i-1 번째 까지 받은 자두 수
         * 4. dp[i-1][j-1] : j-1 만큼 움직였고, i-1 번째 까지 받은 자두 수. (j-1만 움직였다가, 자두 를 받기 위해 j만큼 움직임)
         * 5. 자두를 못 받는 경우는, dp[i-1][j], dp[i-1][j-1], dp[i][j-1] 의 최대값으로 갱신
         * */
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=w; j++) {
                if((plums[i] == 1 && j % 2 == 0) || (plums[i] == 2 && j % 2 != 0)) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + 1;
                } else {
                    dp[i][j] = Math.max(Math.max(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]);
                }
            }
        }

        int answer = dp[n][w];
        System.out.println(answer);
    }
}
