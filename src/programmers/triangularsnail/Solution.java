package programmers.triangularsnail;

public class Solution {

    static int[] moveX = {0,1,-1};
    static int[] moveY = {1,0,-1};

    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];

        int[][] board = new int[n][n];

        int x = 0;
        int y = 0;

        int direct = 0;
        int number = 1;

        for(int i=n; i>0; i--) {
            for(int j=0; j<i; j++) {
                board[y][x] = number;
                if(j == i-1) {
                    direct += 1;
                }
                x = x + moveX[direct % 3];
                y = y + moveY[direct % 3];
                number++;
            }

        }
        int k = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] != 0) {
                    answer[k++] = board[i][j];
                }
            }
        }
        return answer;
    }
}
