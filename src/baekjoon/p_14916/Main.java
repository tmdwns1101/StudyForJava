package baekjoon.p_14916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 - 14916
 * 거스름 돈
 * */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        int answer;

        int count = 0;
        while(true) {
            if(input % 5 == 0) {
                count += input / 5;
                answer = count;
                break;
            } else if(input > 0){
                input -= 2;
                count++;
            } else {
                answer = -1;
                break;
            }
        }

        System.out.println(answer);
    }
}
