package baekjoon.p_14465;

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
        int b = Integer.parseInt(st.nextToken());

        boolean[] brokenLights = new boolean[n];
        for(int i=0; i<b; i++) {
            int brokenLight = Integer.parseInt(br.readLine()) - 1;
            brokenLights[brokenLight] = true;
        }

        int count = 0;
        for(int i=0; i<k; i++) {
            if(brokenLights[i]) count++;
        }
        int answer = count;
        int start = 0;
        int end = k;

        while(end < brokenLights.length) {
            if(brokenLights[start]) {
                count--;
            }
            if(brokenLights[end]) count++;
            start++;
            end++;
            answer = Math.min(answer, count);
        }

        System.out.println(answer);
    }
}
