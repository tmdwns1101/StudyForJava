package programmers.p_가장_먼_노드;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        boolean[][] nodes = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(nodes[i], false);
            nodes[i][i] = true;
        }

        for (int[] e : edge) {
            int pre = e[0] - 1;
            int next = e[1] - 1;
            nodes[pre][next] = true;
            nodes[next][pre] = true;
        }

        int[] distance = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[n];
        queue.offer(0);
        isVisited[0] = true;
        distance[0] = 0;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int i=0; i<n; i++) {
                if(nodes[current][i] && !isVisited[i]) {
                    isVisited[i] = true;
                    distance[i] = distance[current] + 1;
                    queue.offer(i);
                }
            }
        }
        final int maxValue = IntStream.of(distance).max().orElse(-1);
        answer = (int) IntStream.of(distance).filter(e -> e == maxValue).count();

        return answer;
    }
}
