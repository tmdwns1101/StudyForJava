package programmers.p_전력망을_둘로_나누기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    private int answer = Integer.MAX_VALUE;
    public int solution(int n, int[][] wires) {


        boolean[][] isCut = new boolean[n][n];
        for(int i=0; i<n;i ++) {
            isCut[i][i] = true;
        }

        List<List<Integer>> tree = new ArrayList<>();
        for(int i=0; i<n; i++) {
            tree.add(new ArrayList<>());
        }

        for(int[] wire: wires) {
            int v1 = wire[0] - 1;
            int v2 = wire[1] - 1;

            tree.get(v1).add(v2);
            tree.get(v2).add(v1);
        }

        for(int[] wire: wires) {
            int v1 = wire[0] - 1;
            int v2 = wire[1] - 1;
            isCut[v1][v2] = true;
            isCut[v2][v1] = true;
            bfs(tree,v1, isCut, n);
            isCut[v1][v2] = false;
            isCut[v2][v1] = false;
        }
        return answer;
    }


    public void bfs(List<List<Integer>> tree, int start, boolean[][] isCut, int n) {

        boolean[] isVisited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        isVisited[start] = true;
        int count = 0;
        while(!queue.isEmpty()) {
            int front = queue.poll();
            count++;

            List<Integer> nodes = tree.get(front);
            for(int node: nodes) {
                if(!isVisited[node] && !isCut[front][node]) {
                    queue.offer(node);
                    isVisited[node] = true;
                }
            }
        }
        int result = Math.abs(n-count-count);
        answer = Math.min(answer, result);

    }
}
