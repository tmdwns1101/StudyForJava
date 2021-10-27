package programmers.p_기지국설치;

public class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int length = stations.length;

        //전파가 닿을 수 있는 최대 범위
        int area = 2 * w + 1;


        if (length == 0) {
            answer += n / area;
            if (n % area > 0) answer += 1;
        } else if (length == 1) {
            int left = (stations[0]-w-1);
            if(left > 0) {
                answer += left / area;
                if(left % area > 0) answer += 1;
            }
            int right = (n-(stations[0]+w));
            if(right > 0) {
                answer += right / area;
                if(right % area > 0) answer += 1;
            }
        } else {
            //distance : 전파가 안 닿는 범위
            //distance > 0 이고, distance / area 이면, 해당 범위에 설치되는 기지국 수.
            //distance > 0 이고, distance % area 이면, 해당 범위에 area 보다 작아 여분의 범위가 남음. 따라서 1개만 설치하면 해당 여분의 범위가 전파 범위로 들어옴.
            int distance;
            for (int i = 0; i < length; i++) {
                if (i == 0) {
                    distance = (stations[i] - w - 1);
                } else {
                    if (i == length - 1) {
                        distance = (n - (stations[i] + w));
                        if (distance > 0) {
                            answer += distance / area;
                            if (distance % area > 0) answer++;
                        }
                    }
                    distance = (stations[i] - w) - (stations[i - 1] + w) - 1;
                }
                if (distance > 0) {
                    answer += distance / area;
                    if (distance % area > 0) answer += 1;
                }
            }
        }
        return answer;
    }
}
