package programmers.minimumrectangle;

import java.util.Arrays;

public class Solution {
    public int solution(int[][] sizes) {
        Arrays.stream(sizes).forEach(Arrays::sort);

        int[] result = sizes[0];

        for(int i=1; i<sizes.length; i++) {
            for(int j=0; j<2; j++) {
                result[j] = Math.max(result[j],sizes[i][j]);
            }
        }
        return result[0] * result[1];
    }
}
