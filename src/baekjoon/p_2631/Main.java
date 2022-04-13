package baekjoon.p_2631;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] children = new int[n];

        for(int i=0; i<n; i++) {
            children[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n];

        for(int i=0; i<n; i++) {
            dp[i] = 1;
            for(int j=0; j<i; j++) {
                if(children[i] > children[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int max = Arrays.stream(dp).max().orElse(1);
        int answer = n - max;
        System.out.println(answer);

    }
}
