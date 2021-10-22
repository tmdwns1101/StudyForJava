package baekjoon.p_1662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int index = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int result = dfs(s);
        System.out.println(result);
    }
    static int dfs(String s) {

        Stack<Character> stack = new Stack<>();
        int sum = 0;

        while(index < s.length()) {
            char ch = s.charAt(index);
            if(ch == ')') break;
            if(ch == '(') {
                char top = stack.pop();
                index++;
                sum += Integer.parseInt(String.valueOf(top)) * dfs(s);
            } else {
                stack.push(ch);
            }
            index++;
        }
        while(!stack.isEmpty()) {
            sum++;
            stack.pop();
        }
        return sum;
    }
}
