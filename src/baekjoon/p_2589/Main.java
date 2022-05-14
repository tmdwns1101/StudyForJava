package baekjoon.p_2589;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * 보물섬 - 2589
 * */
public class Main {

    private static int n;
    private static int m;
    private static char[][] board;

    private static final int[][] directions = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };

    static class Position{
        int row;
        int col;
        int distance;

        public Position(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        board = new char[n][m];

        for(int i=0; i<n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int answer = -1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 'L') answer = Math.max(answer, bfs(i,j));
            }
        }
        System.out.println(answer);
    }


    private static int bfs(int row, int col) {
        Queue<Position> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[n][m];

        queue.offer(new Position(row, col,0));
        isVisited[row][col] = true;

        int result = -1;
        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            int r = pos.row;
            int c = pos.col;
            int distance = pos.distance;

            for(int[] dir: directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !isVisited[nr][nc] && board[nr][nc] == 'L') {
                    isVisited[nr][nc] = true;
                    queue.offer(new Position(nr,nc,distance+1));
                    result = Math.max(result, distance+1);
                }
            }
        }
        return result;
    }

}
