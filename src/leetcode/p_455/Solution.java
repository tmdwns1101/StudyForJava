package leetcode.p_455;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int answer = 0;
        if(s.length == 0) {
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);

        int j = s.length-1;
        for(int i=g.length-1; i>=0; i--) {
            if(j >=0 && g[i] <= s[j]) {
                answer++;
                j--;
            }
        }

        return answer;
    }
}
