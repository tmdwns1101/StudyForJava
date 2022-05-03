package baekjoon.p_2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 벽 부수고 이동하기 - 2206
 * */
public class Main {

    private static final int[][] directions = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };

    static class Pos {
        int row;
        int col;
        int depth;
        int count;

        public Pos(int row, int col, int count, int depth) {
            this.row = row;
            this.col = col;
            this.count = count;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];

        for(int i=0; i<n; i++) {
            int[] row = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            board[i] = row;
        }



        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(0,0,1,0));

        boolean[][][] isVisited = new boolean[2][n][m];
        isVisited[0][0][0] = true;
        int result = -1;
        while(!queue.isEmpty()) {
            Pos front = queue.poll();
            int row = front.row;
            int col = front.col;
            int depth = front.depth;
            int count = front.count;

            if(row == n-1 && col == m-1) {
                result = count;
                break;
            }

            for(int[] dir: directions) {
                int nRow = row + dir[0];
                int nCol = col + dir[1];
                if(nRow >= 0 && nRow < n && nCol >=0 && nCol < m && !isVisited[depth][nRow][nCol]) {
                    if(board[nRow][nCol] == 0) {
                        queue.offer(new Pos(nRow,nCol,count+1,depth));
                        isVisited[depth][nRow][nCol] = true;
                    } else {
                        if(depth == 0) {
                            queue.offer(new Pos(nRow,nCol,count+1,depth+1));
                            isVisited[depth][nRow][nCol] = true;
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }
}
