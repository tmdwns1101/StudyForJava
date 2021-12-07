package baekjoon.p_2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int[][] directions = {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] heights = new int[n][n];

        int maxHeight = 0;
        int minHeight = 101;
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                heights[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, heights[i][j]);
                minHeight = Math.min(minHeight, heights[i][j]);
            }
        }

        int answer = 0;

        for(int k=minHeight-1; k<=maxHeight; k++) {
            boolean[][] visited = new boolean[n][n];
            int count = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(heights[i][j] > k && !visited[i][j]) {
                        bfs(visited, heights, i, j, k, n);
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }

    private static void bfs(boolean[][] visited, int[][] heights, int row, int col, int height, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        while(!queue.isEmpty()) {
            int[] front = queue.poll();
            int r = front[0];
            int c = front[1];
            for(int i=0; i<4; i++) {
                int nr = r + directions[i][0];
                int nc = c + directions[i][1];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n && heights[nr][nc] > height && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }
    }
}
