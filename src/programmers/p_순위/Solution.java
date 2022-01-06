package programmers.p_순위;

import java.util.*;

public class Solution {

    public int solution(int n, int[][] results) {
        int answer = 0;

        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, 'N');
        }

        for (int[] result : results) {
            int winPlayer = result[0] - 1;
            int losePlayer = result[1] - 1;
            board[winPlayer][losePlayer] = 'W';
            board[losePlayer][winPlayer] = 'L';
        }

        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(board[i][j] == 'N') {
                        if (board[i][k] == 'W' && board[k][j] == 'W') {
                            board[i][j] = 'W';
                        }
                        if (board[i][k] == 'L' && board[k][j] == 'L') {
                            board[i][j] = 'L';
                        }
                    }
                }
            }
        }
        for(char[] score: board) {
            int cnt = 0;
            for(char res: score) {
                if(res == 'W' || res == 'L') cnt++;
            }
            if(cnt == n-1) answer++;
        }

        return answer;
    }

}
