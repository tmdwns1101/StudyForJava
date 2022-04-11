package programmers.p_조이스틱;

public class Solution {
    public int solution(String name) {
        int answer = 0;

        int len = name.length();
        int move = Integer.MAX_VALUE;
        for(int i=0; i<len; i++) {
            char alpha = name.charAt(i);
            int up = alpha - 'A';
            int down = 'Z' - alpha + 1;

            answer += Math.min(up, down);

            int next = i + 1;

            while(next < len && name.charAt(next) == 'A') {
                next++;
            }

            int forwardAndReverse = (i*2) + (len-next);  //정방향으로 i 번째 알파벳으로 오다가, 'A'가 아닌 다음 알파벳으로 역방향으로 이동
            move = Math.min(move, forwardAndReverse);
            int reverseAndForward = (len-next) * 2 + i;  //역방향으로 'A'가 아닌 다음 알파벳으로 이동했다가, 정방향으로 i번째 알파벳으로 이동.
            move = Math.min(move, reverseAndForward);

        }


        return answer + move;
    }
}