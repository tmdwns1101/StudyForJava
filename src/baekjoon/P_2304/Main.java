package baekjoon.P_2304;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] heights = new int[1001];

        int answer = 0;
        int maxLocation = 0;
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            heights[l] = h;
            maxLocation = Math.max(maxLocation, l);
            answer += h;
        }

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<=maxLocation; i++) {
            while(!stack.isEmpty() && heights[i]>heights[stack.peek()]) {
                int top = stack.pop();
                if(stack.isEmpty()) break;
                int distance = i - stack.peek() - 1;
                int area = Math.min(heights[stack.peek()], heights[i]) - heights[top];
                answer += distance * area;
            }
            stack.push(i);
        }
        System.out.println(answer);
    }
}
