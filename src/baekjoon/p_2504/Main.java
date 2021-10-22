package baekjoon.p_2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int index = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int answer = 0;
        if (isValid(s)) {
            answer = recursive(s.toCharArray());
        }
        System.out.println(answer);

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        boolean valid = true;
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == ')' || ch == ']') {
                if (stack.isEmpty()) {
                    valid = false;
                    break;
                }
                char top = stack.pop();
                if (ch == ')' && top != '(' || ch == ']' && top != '[') {
                    valid = false;
                    break;
                }
            } else {
                stack.push(ch);
            }
        }
        if (!stack.isEmpty()) valid = false;
        return valid;
    }

    //(...) 또는 [...] 의 값을 계산 하는 재귀 함수
    //s는 올바른 괄호 문자열이여야함.
    public static int recursive(char[] s) {
        int sum = 0;
        while (index < s.length) {
            char ch = s[index];
            if (ch == ')' || ch == ']') {
                sum = Math.max(sum, 1);
                break;
            } else if (ch == '(') {
                index++;
                sum += 2 * recursive(s);
            } else {
                index++;
                sum += 3 * recursive(s);
            }
            index++;
        }
        return sum;
    }
}
