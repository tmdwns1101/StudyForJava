package baekjoon.p_16173;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 16173
 * 점프왕 쩰리 (Small)
 * */
public class Main {

    static int[][] mv = {
            {1,0}, //아래
            {0,1} //오른쪽
    };

    static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int [][] board = new int[N][N];
        for(int i=0; i<N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        String answer = bfs(board);
        System.out.println(answer);
    }

    public static String bfs(int[][] board) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0,0));

        boolean[][] isVisited = new boolean[N][N];
        isVisited[0][0] = true;

        String result = "Hing";

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            int cRow = point.row;
            int cCol = point.col;
            if(board[cRow][cCol] == -1) {
                result = "HaruHaru";
                break;
            }
            for(int[] move: mv) {
                int nRow = cRow + move[0] * board[cRow][cCol];
                int nCol = cCol + move[1] * board[cRow][cCol];

                if(nRow < N && nCol < N && !isVisited[nRow][nCol]) {
                    queue.offer(new Point(nRow,nCol));
                    isVisited[nRow][nCol] = true;
                }
            }
        }

        return result;
    }
}
