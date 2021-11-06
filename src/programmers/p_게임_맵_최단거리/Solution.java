package programmers.p_게임_맵_최단거리;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private final int[] moveX = {1,-1,0,0};
    private final int[] moveY = {0,0,1,-1};
    public int solution(int[][] maps) {
        int answer = -1;

        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0,0,1});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] front = queue.poll();
            int row = front[0];
            int col = front[1];
            int cnt = front[2];
            if(row == n-1 && col == m-1) {
                answer = cnt;
                break;
            }
            for(int i=0; i<4;i++) {
                int nx = col + moveX[i];
                int ny = row + moveY[i];
                if(nx >=0  && nx < m && ny >= 0 && ny < n && maps[ny][nx] != 0 && !visited[ny][nx]) {
                    queue.offer(new int[]{ny,nx,cnt+1});
                    visited[ny][nx] = true;
                }

            }
        }

        return answer;
    }
}
