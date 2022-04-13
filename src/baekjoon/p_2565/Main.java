package baekjoon.p_2565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 *  백준 - 전깃줄
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] wires = new int[n][2];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            wires[i][0]  = Integer.parseInt(st.nextToken());
            wires[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wires, Comparator.comparingInt(wire -> wire[0]));

        int[] dp = new int[n];

        for(int i=0; i<n; i++) {
            dp[i] = 1;
            for(int j=0; j<i; j++) {
                if(wires[i][1] > wires[j][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int max = Arrays.stream(dp).max().orElse(1);
        int answer = n - max;
        System.out.println(answer);
    }
}
