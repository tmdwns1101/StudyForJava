package baekjoon.p_15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] next = {
            {0, 1}, {-1, 0}, {0, -1}, {1, 0}
    };

    static class Cctv {
        int row;
        int col;
        int number;

        Cctv(int row, int col, int number) {
            this.row = row;
            this.col = col;
            this.number = number;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        List<Cctv> cctvs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] != 0 && board[i][j] != 6) {
                    cctvs.add(new Cctv(i, j, board[i][j]));
                }
            }
        }
        int result = dfs(cctvs, board, 0, n, m);
        System.out.println(result);

    }

    public static int dfs(List<Cctv> cctvs, int[][] board, int index, int n, int m) {
        if (index == cctvs.size()) {
            int result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 0) {
                        result++;
                    }
                }
            }
            return result;
        } else {
            int[] counts = {4, 2, 4, 4, 1};
            Cctv cctv = cctvs.get(index);
            int count = counts[cctv.number - 1];
            int answer = Integer.MAX_VALUE;
            for (int k = 0; k < count; k++) {
                int[][] temp = new int[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        temp[i][j] = board[i][j];
                    }
                }
                rotateCCTV(temp, cctv, k, n, m);
                answer = Math.min(answer, dfs(cctvs, temp, index + 1, n, m));

            }
            return answer;
        }
    }

    public static void rotateCCTV(int[][] board, Cctv cctv, int count, int n, int m) {

        int[][] directions = {
                {0},
                {0, 2},
                {0, 1},
                {0, 1, 2},
                {0, 1, 2, 3}
        };
        int[] direction = directions[cctv.number - 1];
        for (int d : direction) {
            int my = next[(d + count) % 4][0];
            int mx = next[(d + count) % 4][1];
            int row = cctv.row;
            int col = cctv.col;
            int nx = col + mx;
            int ny = row + my;
            while (nx >= 0 && nx < m && ny >= 0 && ny < n && board[ny][nx] != 6) {

                if (board[ny][nx] == 0) {
                    board[ny][nx] = -1;
                }
                nx += mx;
                ny += my;
            }
        }

    }
}
