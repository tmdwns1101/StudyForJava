package leetcode.stockprice;

import java.util.Stack;

public class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<prices.length; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop();
                int distance = i - index;
                answer[index] = distance;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int index = stack.pop();
            int distance = (prices.length-1) - index;
            answer[index] = distance;
        }
        return answer;
    }
}
