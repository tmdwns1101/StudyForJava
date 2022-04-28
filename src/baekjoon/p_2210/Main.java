package baekjoon.p_2210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 2210
 * 숫자판 점프
 * */
public class Main {

    private static Set<String> set = new HashSet<>();
    private static final int N = 5;
    private static final int[][] directions = {
            {-1,0},
            {1,0},
            {0,1},
            {0,-1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[][] board = new String[5][5];

        for(int i=0; i<N; i++) {
            String[] row = br.readLine().split(" ");
            board[i] = row;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                dfs(board, board[i][j],i,j);
            }
        }

        System.out.println(set.size());

    }

    public static void dfs(String[][] board, String str, int row, int col) {
        if(str.length() == 6) {
            set.add(str);
        } else {
            for(int[] dir: directions) {
                int dr = row + dir[0];
                int dc = col + dir[1];
                if(dr >= 0 && dr < N && dc >= 0 && dc < N) {
                    String nextStr = str + board[dr][dc];
                    dfs(board, nextStr, dr, dc);
                }
            }
        }
    }
}
