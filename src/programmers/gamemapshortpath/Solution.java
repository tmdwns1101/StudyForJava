package programmers.gamemapshortpath;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int[] moveX = {1,-1,0,0};
    int[] moveY = {0,0,1,-1};

    public int solution(int[][] maps) {

        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;

        int answer = -1;
        while(!queue.isEmpty()) {
            int[] front = queue.poll();
            int row = front[0];
            int col = front[1];
            int level = front[2];
            if(row == n-1 && col == m-1) {
                answer = level;
                break;
            }
            for(int i=0; i<4; i++) {
                int ny = row + moveY[i];
                int nx = col + moveX[i];
                if(ny >= 0 && ny < n && nx >= 0 && nx < m && maps[ny][nx] == 1 && !visited[ny][nx]) {
                    queue.offer(new int[]{ny,nx, level+1});
                    visited[ny][nx] = true;
                }
            }
        }

        return answer;
    }


}
