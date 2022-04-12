package programmers.p_가장_큰_정사각형_찾기;

import java.util.Arrays;

public class Solution {

    public int solution(int[][] board) {
        int answer = 0;

        if(Arrays.stream(board).flatMapToInt(Arrays::stream).anyMatch(e -> e == 1)) {

            int rowLen = board.length;
            int colLen = board[0].length;

            if(rowLen < 2 || colLen < 2) {
                return 1;
            }

            for(int i=1; i<rowLen; i++) {
                for(int j=1; j<colLen; j++) {
                    if(board[i][j] == 1) {
                        board[i][j] = Math.min(Math.min(board[i-1][j], board[i][j-1]), board[i-1][j-1]) + 1;
                        answer = Math.max(answer, board[i][j]);
                    }
                }
            }
        }

        return answer * answer;
    }
}
