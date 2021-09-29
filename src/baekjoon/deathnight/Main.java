package baekjoon.deathnight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] moveX = {-1, 1, -2, 2, -1, 1};
    static int[] moveY = {-2, -2, 0, 0, 2, 2};

    static class DeathNight {
        int row;
        int col;
        int level;

        DeathNight(int row, int col, int level) {
            this.row = row;
            this.col = col;
            this.level = level;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        boolean[][] check = new boolean[n][n];
        Queue<DeathNight> queue = new LinkedList<>();

        queue.offer(new DeathNight(r1, c1, 0));
        check[r1][c1] = true;

        int answer = -1;
        while (!queue.isEmpty()) {
            DeathNight front = queue.poll();
            int row = front.row;
            int col = front.col;
            int level = front.level;
            if (row == r2 && col == c2) {
                answer = level;
                break;
            }
            for(int i=0; i<6; i++) {
                int nx = col + moveX[i];
                int ny = row + moveY[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !check[ny][nx]) {
                    queue.offer(new DeathNight(ny,nx,level+1));
                    check[ny][nx] = true;
                }
            }
        }
        System.out.println(answer);
    }
}
