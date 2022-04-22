package baekjoon.p_17952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/**
 * 17952 - 과제는 끝나지 않아!
 * */
public class Main {

    static class Task {
        int score;
        int rest;

        public Task(int score, int rest) {
            this.score = score;
            this.rest = rest;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        Stack<Task> stack = new Stack<>();

        int answer = 0;

        for(int i=0; i<n;i++) {
            int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(info[0] == 1) {
                if(info[2] == 1) answer += info[1];
                else stack.push(new Task(info[1],info[2]-1));
            } else {
                if(!stack.empty()) {
                    Task top = stack.peek();
                    top.rest--;
                    if(top.rest == 0) {
                        stack.pop();
                        answer += top.score;
                    }
                }

            }
        }

        System.out.println(answer);
    }
}
