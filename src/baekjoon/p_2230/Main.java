package baekjoon.p_2230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int answer = Integer.MAX_VALUE;

        int left = 0;
        int right = 1;
        while(left < n && right < n) {
            int abs = Math.abs(arr[left]-arr[right]);
            if(abs >= m) {
                left += 1;
                answer = Math.min(answer, abs);
            } else {
                right += 1;
            }
        }
        System.out.println(answer);
    }
}
