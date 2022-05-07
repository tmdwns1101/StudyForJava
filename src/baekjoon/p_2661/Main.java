package baekjoon.p_2661;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 좋은 수열 - 2661
 * */
public class Main {

    private static int n;

    private static String answer;

    private static boolean end = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dfs("");

        System.out.println(answer);
    }

    private static void dfs(String current) {
        if (current.length() == n) {
            answer = current;
            end = true;
        } else {
            for (int i = 1; i <= 3; i++) {
                String next = current + i;
                if(checkGood(next) && !end) {
                    dfs(next);
                }
            }
        }
    }

    private static boolean checkGood(String str) {
        int mid = str.length() / 2;

        boolean result = true;
        for (int i = 1; i <= mid; i++) {
            String left = str.substring(str.length() - i * 2, str.length() - i);
            String right = str.substring(str.length() - i);
            if (left.equals(right)) {
                result = false;
                break;
            }
        }
        return result;
    }

}