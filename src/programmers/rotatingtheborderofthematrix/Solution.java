package programmers.rotatingtheborderofthematrix;

public class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int i = 0;
        int[][] board = makeBoard(rows, columns);
        for(int[] query: queries) {
            answer[i] = rotate(board, query[0]-1, query[1]-1, query[2]-1, query[3]-1);
            i++;
        }
        return answer;
    }

    private int[][]  makeBoard(int rows, int columns) {
        int[][] board = new int[rows][columns];
        int element = 1;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                board[i][j] = element++;
            }
        }
        return board;
    }

    //(x1,y1) , (x2,y2) 는 queries에 주어진 수에서 -1 씩 선행 처리 (배열은 0 부터 시작이므로)
    private int rotate(int[][] board, int x1, int y1, int x2, int y2) {
        int minValue = Integer.MAX_VALUE;
        int temp = board[x1][y1];

        //left 테두리
        for(int i=x1; i<x2; i++) {
            board[i][y1] = board[i+1][y1];
            minValue = Math.min(board[i][y1], minValue);
        }

        //bottom 테두리
        for(int i=y1; i<y2; i++) {
            board[x2][i] = board[x2][i+1];
            minValue = Math.min(board[x2][i], minValue);
        }

        //right 테두리
        for(int i=x2; i>x1; i--) {
            board[i][y2] = board[i-1][y2];
            minValue = Math.min(board[i][y2], minValue);
        }
        //top 테두리
        for(int i=y2; i>y1; i--) {
            board[x1][i] = board[x1][i-1];
            minValue = Math.min(board[x1][i], minValue);
        }
        board[x1][y1+1] = temp;
        minValue = Math.min(board[x1][y1+1],minValue);

        return minValue;
    }
}
