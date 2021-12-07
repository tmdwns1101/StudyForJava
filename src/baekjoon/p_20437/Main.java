package baekjoon.p_20437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        String[] strs = new String[testCase];
        int[] kArray = new int[testCase];
        for(int t=0; t<testCase; t++) {

            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());

            strs[t] = str;
            kArray[t] = k;
        }
        for(int i=0; i<testCase; i++) {
            solution(strs[i].toCharArray(), kArray[i]);
        }


    }


    public static void solution(char[] str, int k) {
        int[] alpha = new int[26];
        for(char c: str) {
            alpha[c-'a']++;
        }

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for(int i=0; i<str.length; i++) {
            if(alpha[str[i]-'a'] >= k) {
                int count = 0;
                for(int j=i; j< str.length; j++) {
                    if(str[i] == str[j]) {
                        count++;
                    }
                    if(count == k) {
                        minValue = Math.min(minValue, j - i + 1);
                        maxValue = Math.max(maxValue, j - i + 1);
                        break;
                    }
                }
            }
        }
        if(maxValue != Integer.MIN_VALUE && minValue != Integer.MAX_VALUE) {
            System.out.println(minValue+" "+maxValue);
        }else {
            System.out.println("-1");
        }
    }


}
