package leetcode.p_134;

import java.util.stream.IntStream;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int answer = 0;
        int gasSum = IntStream.of(gas).sum();
        int costSum = IntStream.of(cost).sum();
        if(gasSum < costSum) {
            answer = -1;
        } else {
            int len = gas.length;
            int tank = 0;

            for(int i=0; i<len; i++) {
                if(gas[i] + tank < cost[i]) {
                    answer = i + 1;
                    tank = 0;
                } else {
                    tank += (gas[i] - cost[i]);
                }
            }
        }
        return answer;
    }
}
