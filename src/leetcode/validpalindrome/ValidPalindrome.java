package leetcode.validpalindrome;

import java.util.*;

public class ValidPalindrome {
    public static void main(String[] args) {
        boolean result = solution(" ");
        System.out.println(result);
    }

    public static boolean solution(String s) {
        boolean answer = true;
        String[] charArray = s
                .toLowerCase()
                .replaceAll(" ","")
                .split("");
        Deque<String> deque = new ArrayDeque<>();

        for(String elem : charArray) {
            if(elem.length() > 0 && Character.isLetterOrDigit(elem.toCharArray()[0])) {
                deque.addLast(elem);
            }
        }

        while(deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) {
                answer = false;
                break;
            }
        }
        return answer;
    }

}
