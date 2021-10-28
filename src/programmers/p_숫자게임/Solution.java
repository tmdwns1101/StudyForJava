package programmers.p_숫자게임;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        List<Integer> sortedA = IntStream.of(A)
                .boxed()
                .sorted((e1, e2) -> Integer.compare(e2, e1))
                .collect(Collectors.toList());
        List<Integer> sortedB = IntStream.of(B)
                .boxed()
                .sorted((e1, e2) -> Integer.compare(e2, e1))
                .collect(Collectors.toList());
        int bIdx = 0;
        for (int aPlayer: sortedA) {
            int bPlayer = sortedB.get(bIdx);
            if (aPlayer < bPlayer) {
                bIdx++;
                answer++;
            }
        }
        return answer;
    }
}
