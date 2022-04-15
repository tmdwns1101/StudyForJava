package programmers.p_양궁대회;

import java.util.Arrays;

public class Solution {

    private int maxScore = Integer.MIN_VALUE;
    private int[] answer;
    private final int LEN = 11;

    public int[] solution(int n, int[] info) {

        int[] ryan = new int[LEN];
        answer = new int[]{-1};
        dfs(0,n, info, ryan);
        return answer;
    }

    private void dfs(int idx, int arrowCount, int[] apeach, int[] ryan) {
        if (idx == LEN || arrowCount == 0) {
            ryan[LEN-1] += arrowCount;
            int dif = this.calcScore(apeach, ryan);
            if(dif > 0 && dif >= maxScore) {

                if(dif == maxScore && !this.moreLowScore(ryan)) return;
                maxScore = dif;
                answer = Arrays.copyOf(ryan, LEN);
            }

            ryan[LEN-1] -= arrowCount;
        } else {
            if(apeach[idx] < arrowCount) {
                ryan[idx] += apeach[idx] + 1;
                dfs(idx+1, arrowCount - apeach[idx] - 1, apeach, ryan);
                ryan[idx] -= apeach[idx] + 1;
            }
            dfs(idx+1, arrowCount, apeach, ryan);
        }
    }

    private int calcScore(int[] apeach, int[] ryan) {
        int apeachScore = 0;
        int ryanScore = 0;
        for(int i=0; i< LEN; i++) {
            int cur = 10 - i;
            if(apeach[i] >= ryan[i]) {
                if(apeach[i] != 0) apeachScore += cur;
            } else {
                ryanScore += cur;
            }
        }
        return ryanScore - apeachScore;
    }

    private boolean moreLowScore(int[] info) {
        boolean flag = false;
        for(int i=LEN-1; i>=0; i--) {
            if(answer[i] < info[i]) {
                flag = true;
                break;
            }
            if(answer[i] > info[i]) {
                break;
            }
        }
        return flag;
    }

}
