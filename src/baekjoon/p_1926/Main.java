package baekjoon.p_1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;

    private static int[][] directions = {
            {-1,0},
            {1,0},
            {0,1},
            {0,-1}
    };

    private static int maxArea;

    static class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];

        for(int i=0; i<n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int count = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 1) {
                    count++;
                    bfs(board, i,j);
                }
            }
        }

        System.out.println(count);
        System.out.println(maxArea);
    }

    private static void bfs(int[][]board, int row, int col) {

        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(row, col));
        board[row][col] = 0;
        int count = 0;
        while(!queue.isEmpty()) {
            Position front = queue.poll();
            count++;
            maxArea = Math.max(maxArea, count);

            for(int[] dir: directions) {
                int nRow = front.row + dir[0];
                int nCol = front.col + dir[1];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m  && board[nRow][nCol] == 1) {
                    queue.offer(new Position(nRow,nCol));
                    board[nRow][nCol] = 0;
                }
            }

        }
    }
}
