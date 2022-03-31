package programmers.p_문자열_내_마음대로_정렬하기;

import java.util.Arrays;

public class Solution {

    public String[] solution(String[] strings, int n) {

        return Arrays.stream(strings).sorted((s1, s2) -> {
            char c1 = s1.charAt(n);
            char c2 = s2.charAt(n);
            if (c1 != c2) {
                return Character.compare(c1, c2);
            } else {
                return s1.compareTo(s2);
            }
        }).toArray(String[]::new);
    }
}
