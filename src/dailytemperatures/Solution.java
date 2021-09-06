package dailytemperatures;

import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];
        for(int i=0;  i < temperatures.length; i++) {
            while(!stack.isEmpty() &&  temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                int distance = i - index;
                answer[index] = distance;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            answer[stack.pop()] = 0;
        }

        return answer;
    }
}
