package programmers.monthlychallenge;

public class Solution5 {
    public int solution(int n) {
        int answer = -1;
        for(int i=2; i*i<n; i++) {
            if(n % i == 1) {
                answer = i;
                break;
            }
        }

        return answer == -1 ? n-1 : answer;
    }
}
