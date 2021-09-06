package validParentheses;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] parentheses = s.toCharArray();
        Map<Character,Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        for (char parenthesis : parentheses) {
           if(parenthesis == '(' || parenthesis == '{' || parenthesis == '[') {
               stack.push(parenthesis);
           } else {
               if(stack.isEmpty()) {
                   return false;
               }
               char top = stack.peek();
               if(map.get(top) == parenthesis) {
                   stack.pop();
               } else {
                   return false;
               }
           }
        }
        return stack.isEmpty();
    }
}
