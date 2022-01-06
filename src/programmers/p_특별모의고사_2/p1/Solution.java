package programmers.p_특별모의고사_2.p1;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private final int[] moveX = {1,-1,0,0};
    private final int[] moveY = {0,0,1,-1};

    private class Virus {
        int row;
        int col;
        int count;

        Virus(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }

    public int[][] solution(int rows, int columns, int max_virus, int[][] queries) {
        int[][] answer = new int[rows][columns];

        for(int[] query: queries) {
            int row = query[0]-1;
            int col = query[1]-1;
            if(answer[row][col] >= max_virus) {
                bfs(answer, row, col, max_virus);
            } else {
                answer[row][col]++;
            }

        }

        return answer;
    }

    private void bfs(int[][] board, int row, int col, int max_virus) {
        Queue<Virus> queue = new LinkedList<>();
        queue.offer(new Virus(row,col,board[row][col]));
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        visited[row][col] = true;
        while(!queue.isEmpty()) {
            Virus virus = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = virus.col + moveX[i];
                int ny = virus.row + moveY[i];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[ny][nx]) {
                    if(board[ny][nx] < max_virus) {
                        board[ny][nx]++;
                    } else {
                        queue.offer(new Virus(ny,nx,board[ny][nx]));
                    }
                    visited[ny][nx] = true;
                }
            }
        }
    }
}
