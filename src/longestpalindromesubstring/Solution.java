package longestpalindromesubstring;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        String result = solution("ccd");
        System.out.println("result = " + result);
    }
    public static String solution(String s) {
        String answer = "";

        StringBuilder builder = new StringBuilder();
        String reveresedString = builder.append(s).reverse().toString();
        if(s.length() < 2 || s.equals(reveresedString)) {
            return s;
        }

        class Expand {

            String targetString;

            public Expand(String str) {
                targetString = str;
            }

            public String expand(int left, int right) {

                while (left >= 0 && right < targetString.length() && targetString.charAt(left) == targetString.charAt(right)) {
                    left -= 1;
                    right += 1;
                }

                if(right > targetString.length()) right = targetString.length();
                return targetString.substring(left+1, right);
            }
        }

        Expand expand = new Expand(s);
        for(int i=0; i<s.length(); i++) {
            String res1 = expand.expand(i,i+1);
            String res2 = expand.expand(i,i+2);
            String temp = res1.length() > res2.length() ? res1 : res2;
            answer = answer.length() > temp.length() ? answer : temp;
        }
        return answer;
    }
}
