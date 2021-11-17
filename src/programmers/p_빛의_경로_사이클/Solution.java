package programmers.p_빛의_경로_사이클;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    private static boolean[][][] isVisited;
    private static final int[][] direct = {
            {0, 1},   //동
            {1, 0},   //남
            {0, -1},  //서
            {-1, 0}  //북
    };


    public int[] solution(String[] grid) {

        int n = grid.length;
        int m = grid[0].length();
        isVisited = new boolean[n][m][4];

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    if (!isVisited[i][j][k]) {
                        int res = search(grid, n, m, i, j, k);
                        list.add(res);
                    }
                }
            }
        }
        return list.stream().sorted().mapToInt(i -> i).toArray();
    }

    private int search(String[] grid, int n, int m, int row, int col, int dir) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col, dir});
        isVisited[row][col][dir] = true;
        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            int d = front[2];
            int ny = (front[0] + direct[d][0] + n) % n;
            int nx = (front[1] + direct[d][1] + m) % m;

            int nd;

            if (grid[ny].charAt(nx) == 'S') {
                nd = d;
            } else if (grid[ny].charAt(nx) == 'L') {
                nd = d - 1 < 0 ? 3 : d - 1;
            } else {
                nd = d + 1 > 3 ? 0 : d + 1;
            }
            if (!isVisited[ny][nx][nd]) {
                queue.offer(new int[]{ny, nx, nd});
                isVisited[ny][nx][nd] = true;
            }

            count++;

        }
        return count;
    }
}
