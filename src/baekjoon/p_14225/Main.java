package baekjoon.p_14225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 14225 - 부분수열의 합
 * */
public class Main {

    private static final int MAX_VALUE = 20 * 100000;
    private static boolean[] check = new boolean[MAX_VALUE + 1];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        solution(numbers, 0, 0);

        int answer = 0;

        for(int i=1; i<check.length; i++) {
            if(!check[i]) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }

    public static void solution(int[] numbers, int start, int sum) {

        if (start == numbers.length) {
            check[sum] = true;
        } else {
            solution(numbers, start + 1, sum + numbers[start]);
            solution(numbers, start + 1, sum);
        }
    }
}
