package programmers.p_제일_작은_수_제거하기;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public int[] solution(int[] arr) {

        if(arr.length == 1) return new int[]{-1};

        int minValue = Arrays.stream(arr).min().orElse(-1);
        return IntStream.of(arr).filter(e -> e != minValue).toArray();
    }
}
