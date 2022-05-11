package baekjoon.p_3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] forest = new char[n][m];

        Queue<int[]> sQueue = new LinkedList<>();
        Queue<int[]> wQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            forest[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (forest[i][j] == 'S') {
                    sQueue.offer(new int[]{i, j, 0});
                }
                if (forest[i][j] == '*') {
                    wQueue.offer(new int[]{i, j});
                }
            }
        }

        int answer = -1;

        while (!wQueue.isEmpty() || !sQueue.isEmpty()) {

            List<int[]> wtemp = new ArrayList<>();
            while (!wQueue.isEmpty()) {
                int[] water = wQueue.poll();
                for (int[] dir : directions) {
                    int nextRow = water[0] + dir[0];
                    int nextCol = water[1] + dir[1];
                    if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && (forest[nextRow][nextCol] == '.' || forest[nextRow][nextCol] == 'S')) {
                        wtemp.add(new int[]{nextRow, nextCol});
                        forest[nextRow][nextCol] = '*';
                    }
                }
            }
            wQueue.addAll(wtemp);

            List<int[]> stemp = new ArrayList<>();
            while (!sQueue.isEmpty()) {
                int[] s = sQueue.poll();
                if(forest[s[0]][s[1]] == 'D') {
                    answer = s[2];
                    break;
                }
                for (int[] dir : directions) {
                    int nextRow = s[0] + dir[0];
                    int nextCol = s[1] + dir[1];
                    if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m) {
                        if(forest[nextRow][nextCol] == '.') {
                            stemp.add(new int[]{nextRow, nextCol, s[2] + 1});
                            forest[nextRow][nextCol] = 'S';
                        }
                        if(forest[nextRow][nextCol] == 'D') {
                            stemp.add(new int[]{nextRow, nextCol, s[2] + 1});
                        }
                    }
                }
            }
            if (answer != -1) break;
            sQueue.addAll(stemp);
        }

        if (answer == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(answer);
        }
    }
}
