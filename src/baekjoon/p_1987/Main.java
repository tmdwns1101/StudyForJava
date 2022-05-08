package baekjoon.p_1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 알파벳 - 1987
 * */
public class Main {

    private static int n;
    private static int m;

    private static final int[][] directions = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];
        for(int i=0; i<n; i++) {
            char[] row = br.readLine().toCharArray();
            board[i] = row;
        }

        boolean[] isVisited = new boolean[26];

        isVisited[board[0][0]-'A'] = true;
        int answer = dfs(board,isVisited,0,0,1);
        System.out.println(answer);
    }

    private static int dfs(char[][] board, boolean[] isVisited, int row, int col, int count) {
        int result = count;

        for(int[] dir: directions) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];

            if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m) {
                int next = board[nextRow][nextCol] - 'A';
                if(!isVisited[next]) {
                    isVisited[next] = true;
                    result = Math.max(result, dfs(board,isVisited,nextRow,nextCol,count+1));
                    isVisited[next] = false;
                }

            }
        }
        return result;
    }

}
