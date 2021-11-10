package baekjoon.p_11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for(int i=0; i<n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int answer = 0;
        while(k > 0) {
            int max_value = 0;
            for(int coin: coins) {
                if(coin <= k) {
                    max_value = Math.max(max_value, coin);
                }
            }
            answer += k / max_value;
            k %= max_value;
        }
        System.out.println(answer);
    }
}
