package distancevalid;

import java.util.Arrays;


public class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer, 1);
        int index = 0;
        for (String[] place : places) {
            char[][] board = makeBoard(place);
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (board[i][j] == 'P') {
                        answer[index] = Math.min(validLocation(board, i, j), answer[index]);
                    }
                }
            }
            index++;
        }


        return answer;
    }

    private char[][] makeBoard(String[] place) {
        char[][] board = new char[5][5];
        for (int i = 0; i < place.length; i++) {
            board[i] = place[i].toCharArray();
        }
        return board;
    }

    /*
    * description
    *   - 주어진 응시자의 위치를 확인하여, 응시자들끼리 거리두기가 유효한지 확인하는 메서드
    * return
    *   - 1 : 해당 응시자는 거리두기를 유효하게 하고 있음.
    *   - 0 : 해당 응시자는 거리두기가 유요하지 않음.
    *
    * 1. 상,하,좌,우 확인하여 다른 응시자들이 있는지 확인
    *   - 응시자가 한 명이라도 있으면 0 반환
    * 2. 상상, 하하, 좌좌, 우우 확인하여 다른 응시자들이 있는지 확인
    *   - 응시자가 있고, 파티션('X')이 안되어 있으면 0 반환
    * 3. 좌측위 대각선, 우측 위 대각선, 좌측 아래 대각선, 우측 아래 대각선에 응시자가 있는지 확인
    *   - 응시자가 있고, 파티션('X')으로 가려져 있지 않으면 0 반환
    *
    * */
    private int validLocation(char[][] board, int row, int col) {
        int valid = 1;
        class Pair {
            int row;
            int col;

            Pair(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }

        Pair[] crossCheck = {new Pair(-1,0),new Pair(1,0), new Pair(0,-1), new Pair(0,1)};
        Pair[] diagonalCheck = {new Pair(-1,-1), new Pair(-1,1),new Pair(1,-1),new Pair(1,1)};

        //top, bottom, left, right 확인
        for (int i = 0; i < 4; i++) {
            int ny = row+crossCheck[i].row;
            int nx = col+crossCheck[i].col;
            if(nx >=0 && nx < 5 && ny >=0 && ny < 5 && board[ny][nx] == 'P') {
                return 0;
            }
        }

        for (int i = 0; i < 4; i++) {
            int ny = row+crossCheck[i].row;
            int nx = col+crossCheck[i].col;
            int nny = row+(crossCheck[i].row*2);
            int nnx = col+(crossCheck[i].col*2);
            if(nnx >=0 && nnx < 5 && nny >=0 && nny < 5 && board[nny][nnx] == 'P') {
                if(board[ny][nx] != 'X') {
                    return 0;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            int ny = row+diagonalCheck[i].row;
            int nx = col+diagonalCheck[i].col;
            if(nx >=0 && nx < 5 && ny >=0 && ny < 5 && board[ny][nx] == 'P') {
                //PX
                //XP 인지 확인하는 절차
                if(board[row+diagonalCheck[i].row][col] != 'X' || board[row][col+diagonalCheck[i].col] != 'X') {
                    return 0;
                }
            }
        }
        return 1;
    }

}
