package baekjoon.p_2638;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static class Point {
        int row;
        int col;

        Point(int row, int col)  {
            this.row = row;
            this.col = col;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];

        List<Point> cheeseList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            board[i] = row;
            for(int j=0; j<m; j++) {
                if(row[j] == 1) cheeseList.add(new Point(i,j));
            }
        }
        int answer = 0;

        while(cheeseList.size() > 0) {
            boolean[][] visited = new boolean[n][m];
            bfs(board, visited, n, m);
            meltCheeses(board, cheeseList);
            answer++;
        }
        System.out.println(answer);

    }

    private static void bfs(int[][] board, boolean[][] visited, int n, int m) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        visited[0][0] = true;
        board[0][0] = 2;
        while(!queue.isEmpty()) {
            Point point = queue.poll();
            int xpos = point.col;
            int ypos = point.row;
            for(int[] d: direct) {
                int nx = xpos + d[1];
                int ny = ypos + d[0];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && board[ny][nx] != 1 && !visited[ny][nx]) {
                    queue.offer(new Point(ny, nx));
                    visited[ny][nx] = true;
                    board[ny][nx] = 2;
                }
            }
        }
    }

    private static void meltCheeses(int[][] board, List<Point> cheeseList) {
        List<Point> meltCheeseList = new ArrayList<>();
        for(Point cheese: cheeseList) {
            int row = cheese.row;
            int col = cheese.col;

            int exposed = 0;
            for(int[] d: direct) {
                int ny = row + d[0];
                int nx = col + d[1];
                if(board[ny][nx] == 2) exposed++;
            }
            if(exposed >= 2) {
                board[row][col] = 0;
                meltCheeseList.add(cheese);
            }
        }
        cheeseList.removeAll(meltCheeseList);
    }
}
