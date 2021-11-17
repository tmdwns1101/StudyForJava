package programmers.p_조이스틱;

public class Solution {
    public int solution(String name) {
        int answer = 0;

        int len = name.length();
        boolean[] checked = new boolean[name.length()];
        int n = 0;
        for(int i=0; i<len; i++) {
            if(name.charAt(i) == 'A') {
                checked[i] = true;
            } else {
                n++;
            }
        }
        int cursor = 0;

        while(n > 0) {
            if(!checked[cursor]) {
                n--;
                checked[cursor] = true;
            }
            char alphabet = name.charAt(cursor);
            //1. 해당 위치 문자로 변환하는데 필요한 연산
            int right = alphabet - 'A';
            int left = 26 - (alphabet-'A');
            answer += Math.min(left, right);

            if(n > 0) {
                //2. 다음 문자로 이동하는 최소 거리
                int leftTo = cursor;
                int lCnt = 0;
                int rightTo = cursor;
                int rCnt = 0;
                for (int i = 0; i < len-1; i++) {
                    leftTo = (leftTo - 1 + len) % len;
                    lCnt++;
                    if (!checked[leftTo]) break;
                }
                for (int i = 0; i < len-1; i++) {
                    rightTo = (rightTo + 1) % len;
                    rCnt++;
                    if (!checked[rightTo]) break;
                }
                int min = Math.min(lCnt, rCnt);
                answer += min;
                cursor = min == lCnt ? leftTo : rightTo;
            }
        }


        return answer;
    }
}
