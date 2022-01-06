package programmers.p_입국심사;

public class Solution {
    static final long MAX_TIME = 1000000000;
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;

        long left = 1;
        long right = MAX_TIME * n;
        while(left <= right) {
            long mid = (left+right) / 2;
            int temp = n;
            for(int time: times) {
                temp -= mid / time;
            }
            if(temp <= 0) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}
