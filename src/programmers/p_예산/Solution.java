package programmers.p_예산;

import java.util.stream.IntStream;

public class Solution {
    public int solution(int[] budgets, int M) {
        int answer = 0;

        int left = 0;
        int right = IntStream.of(budgets).max().orElse(0);

        while (left <= right) {
            final int mid = (left + right) / 2;
            int sum = IntStream.of(budgets)
                    .map(budget -> Math.min(budget, mid))
                    .sum();
            if (sum <= M) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}
