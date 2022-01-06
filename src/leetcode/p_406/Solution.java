package leetcode.p_406;

import java.util.*;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((e1, e2) -> {
            if(e1[0] == e2[0]) return Integer.compare(e1[1],e2[1]);
            return Integer.compare(e2[0],e1[0]);
        });
        for(int[] p: people) {
            queue.offer(p);
        }
        List<int[]> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            int[] front = queue.poll();
            list.add(front[1],front);
        }
        return list.toArray(new int[list.size()][2]);
    }
}
