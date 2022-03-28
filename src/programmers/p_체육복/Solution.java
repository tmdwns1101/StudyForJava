package programmers.p_체육복;

import java.util.Arrays;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        boolean[] haveSuit = new boolean[n];
        boolean[] reserveStudents = new boolean[n]; //모두 여유옷이 없음을 가정

        //모두 체육복이 있다고 초기화
        Arrays.fill(haveSuit, true);

        //체육복을 도둑 맞았을 경우 false로 값을 변경
        for(int stu: lost) {
            haveSuit[stu-1] = false;
        }

        /*
        * 1. 여유옷이 있는 학생이 도둑 맞았을 경우 hasSuit를 true, reserveStudents 는 아니게 됨.
        * 2. 여유옷이 있는 학생이 도둑 맞지 않았으면, reserveStudents 를 true로 여유옷이 있는 학생이 됨.
        * */
        for(int stu: reserve) {
            if(!haveSuit[stu-1]) haveSuit[stu-1] = true;
            else reserveStudents[stu-1] = true;
        }

        for(int i=0; i<n; i++) {

            /*
            * 1.체육복이 없을 경우, 앞 사람에게 먼저 체육복 요구
            * 2.앞 사람이 여유옷이 있을 경우, 체육복을 얻고(haveSuit = true)
            * 3.앞 사람의 여유옷 (reserveStudents = false)을 제거
            * */
            if(!haveSuit[i]) {
                if(i > 0 && reserveStudents[i-1]) {
                    haveSuit[i] = true;
                    reserveStudents[i-1] = false;
                }
            }
            /*
            * 앞 사람에게 못 빌렸을 경우
            * 1. 뒷 사람에게 체육복 요구
            * */
            if(!haveSuit[i]) {
                if(i < n-1 && reserveStudents[i+1]) {
                    haveSuit[i] = true;
                    reserveStudents[i+1] = false;
                }
            }

            if(haveSuit[i]) { //체육복 있는 학생 개수 카운팅
                answer++;
            }
        }

        return answer;
    }
}
