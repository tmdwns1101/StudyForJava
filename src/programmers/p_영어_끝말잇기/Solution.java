package programmers.p_영어_끝말잇기;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        Set<String> set = new HashSet<>();
        if(words[0].length() == 1) {
            answer[0] = 1;
            answer[1] = 1;
            return answer;
        }
        set.add(words[0]);

        for(int i=1; i< words.length; i++) {
            String word = words[i];
            String prevLastAlpha = words[i-1].substring(words[i-1].length() -1);
            set.add(word);
            if(set.size() != i + 1 || !word.startsWith(prevLastAlpha) || word.length() == 1) {
                int losePlayer = (i % n) + 1;
                int round = (i / n) + 1;
                answer[0] = losePlayer;
                answer[1] = round;
                break;
            }
        }
        return answer;
    }
}
