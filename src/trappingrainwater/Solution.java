package trappingrainwater;

import java.util.Stack;

public class Solution {
    public int trap(int[] height) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<height.length; i++) {

            while(!stack.isEmpty() && height[i]>height[stack.peek()]) {
                int top = stack.pop();
                if(stack.isEmpty()) break;
                int distance = i - stack.peek() - 1;
                int water = Math.min(height[i], height[stack.peek()]) - height[top];
                answer += distance*water;
            }
            stack.push(i);
        }
        return answer;
    }
}
