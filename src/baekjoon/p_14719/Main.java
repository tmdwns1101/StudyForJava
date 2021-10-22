package baekjoon.p_14719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] heights = new int[w];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<w; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for(int i=0; i<w; i++) {
            while(!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                int top = stack.pop();
                if(stack.isEmpty()) break;
                int distance = i - stack.peek() - 1;
                int water = Math.min(heights[i],heights[stack.peek()]) - heights[top];
                answer += distance * water;
            }
            stack.push(i);
        }
        System.out.println(answer);
    }
}
