package programmers.p_배달;

import java.util.Arrays;

public class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[][] distances = new int[N][N];
        for(int i=0; i<N; i++) {
            Arrays.fill(distances[i],Integer.MAX_VALUE);
            distances[i][i] = 0;
        }
        for(int[] r: road) {
            int townA = r[0]-1;
            int townB = r[1]-1;
            int distance = r[2];
            distances[townA][townB] = Math.min(distances[townA][townB], distance);
            distances[townB][townA] = distances[townA][townB];
        }

        int[] dp = new int[N];
        boolean[] visited = new boolean[N];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        visited[0] = true;
        for(int i=1; i<N; i++) {
            dp[i] = distances[0][i];
        }

        while (true){

            int distance = Integer.MAX_VALUE;
            int next = -1;
            for(int i=0; i<N; i++) {
                int cur = dp[i];
                if(!visited[i] && cur < distance) {
                    next = i;
                    distance = cur;
                }
            }
            if(next == -1) break;
            visited[next] = true;
            for(int i=0; i<N; i++) {
                if(distances[next][i] != Integer.MAX_VALUE && dp[i] > dp[next] + distances[next][i]) {
                    dp[i] = dp[next] + distances[next][i];
                }
            }
        }
        answer = (int) Arrays.stream(dp).filter(e -> e <= K).count();
        return answer;
    }
}
