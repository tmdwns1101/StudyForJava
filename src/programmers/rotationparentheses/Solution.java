package programmers.rotationparentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/*
* 프로그래머스 괄호 회전하기
* */
public class Solution {
    public int solution(String s) {
        int answer = 0;

        String rotationStr = s;
        for(int i=0; i<s.length(); i++) {
            answer = isValidParentheses(rotationStr) ? answer + 1 : answer;
            rotationStr = rotation(rotationStr);
        }



        return answer;
    }

    public String rotation(String s) {
        return s.substring(1)+s.charAt(0);
    }

    public boolean isValidParentheses(String s) {
        boolean valid = true;

        Stack<Character> stack = new Stack<>();

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        char[] parentheses = s.toCharArray();

        for (char parenthesis : parentheses) {
            if(parenthesis == '(' || parenthesis == '{' || parenthesis == '[') stack.push(parenthesis);
            else {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.peek();
                    if(map.get(top) != parenthesis) {
                        return false;
                    }
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}
