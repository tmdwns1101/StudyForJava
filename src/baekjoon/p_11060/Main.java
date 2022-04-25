package baekjoon.p_11060;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 점프 점프 - 11060
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] fields = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);

        while (!queue.isEmpty()) {
            int front = queue.poll();

            int jump = fields[front];
            for(int i=1; i<=jump; i++) {
                int next = front + i;
                if(next < n && dp[front] + 1 < dp[next]) {
                    dp[next] = dp[front] + 1;
                    queue.offer(next);
                }
            }
        }

        if(dp[n-1] == Integer.MAX_VALUE)  dp[n-1] = -1;

        System.out.println(dp[n-1]);
    }
}
