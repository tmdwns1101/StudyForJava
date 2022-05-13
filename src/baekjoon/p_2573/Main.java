package baekjoon.p_2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 빙산 - 2573
 * */
public class Main {

    private static int n;
    private static int m;


    private static final int[][] directions = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };
    static class Position {
        int row;
        int col;
        int height;

        public Position(int row, int col,int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];


        Queue<Position> queue = new LinkedList<>();

        for(int i=0; i<n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<m; j++) {
                if(board[i][j] != 0) {
                    queue.offer(new Position(i,j, board[i][j]));
                }
            }
        }

        int answer = bfs(board, queue);
        if(answer == -1){
            answer = 0;
        }
        System.out.println(answer);


    }

    private static int bfs(int[][] board, Queue<Position> queue) {

        int year = 0;

        while(true) {
            year++;
            List<Position> temp = new ArrayList<>();
            List<Position> destory = new ArrayList<>();
            while (!queue.isEmpty()) {
                Position pos = queue.poll();
                int row = pos.row;
                int col = pos.col;


                for(int[] dir: directions) {
                    int nextRow = row + dir[0];
                    int nextCol = col + dir[1];
                    if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && board[nextRow][nextCol] == 0) {
                        pos.height--;
                    }
                }

                if(pos.height <= 0){
                    destory.add(pos);
                } else {
                    temp.add(pos);
                }
            }

            for(Position des: destory) {
                board[des.row][des.col] = 0;
            }

            for(Position t: temp) {
                queue.offer(t);
            }

            if(queue.isEmpty()) {
                year = -1;
                break;
            }

            //빙산 덩어리 계산
            int count = 0;
            boolean[][] isVisited = new boolean[n][m];
            for(Position pos: temp) {
                if(!isVisited[pos.row][pos.col]) {
                    count++;
                    search(board, pos.row, pos.col, isVisited);
                }
            }

            if(count >= 2) break;

            temp = null;
            destory = null;


        }


        return year;

    }


    private static void search (int[][] board, int row, int col, boolean[][] isVisited) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{row, col});
        isVisited[row][col] = true;

        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            int r = front[0];
            int c = front[1];

            for(int[] dir: directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && board[nr][nc] != 0 && !isVisited[nr][nc]) {
                    queue.offer(new int[]{nr,nc});
                    isVisited[nr][nc] = true;
                }
            }
        }
    }
}
