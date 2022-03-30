package programmers.p_이상한문자만들기;

public class Solution {
    public String solution(String s) {

        String[] words = s.split("");

        int count = 0;
        StringBuilder rs = new StringBuilder();

        for(String word: words) {
            if(word.equals(" ")){
                count = 0;
                rs.append(word);
            } else {
                if(count % 2 == 0) {
                    rs.append(word.toUpperCase());
                } else {
                    rs.append(word.toLowerCase());
                }
                count++;
            }
        }

        return rs.toString();
    }
}
