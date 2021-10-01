package baekjoon.youthshark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] moveX = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] moveY = {-1, -1, 0, 1, 1, 1, 0, -1};

    static class Fish {
        int row;
        int col;
        int direct;

        Fish(int row, int col, int direct) {
            this.row = row;
            this.col = col;
            this.direct = direct;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[4][4];

        Fish[] fishes = new Fish[17];
        for (int i = 0; i < 4; i++) {
            int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < 8; j += 2) {
                int k = j / 2;
                board[i][k] = row[j];
                int direct = row[j+1]-1;
                fishes[row[j]] = new Fish(i, k, direct);
            }
        }

        //상어 (0,0) 에 있는물고기 잡아먹기
        int number = board[0][0];
        int sum = number;
        Fish deadFish = fishes[number];
        int sharkDirect = deadFish.direct;
        fishes[number] = null;
        //상어가 있는 위치는 -1
        board[0][0] = -1;
        int result = dfs(board, fishes, 0,0, sharkDirect, sum);
        System.out.println(result);

    }

    public static int[][] moveFish(int[][] board, Fish[] fishes) {
        int[][] clonedBoard = new int[4][4];
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                clonedBoard[i][j] = board[i][j];
            }
        }
        for (Fish fish : fishes) {
            if (fish != null) {
                int row = fish.row;
                int col = fish.col;
                int direct = fish.direct;
                for (int i = 0; i < 8; i++) {
                    int nx = col + moveX[direct % 8];
                    int ny = row + moveY[direct % 8];
                    if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || clonedBoard[ny][nx] == -1) {
                        direct = (direct + 1) % 8;
                    } else {
                        if (clonedBoard[ny][nx] == 0) {
                            clonedBoard[ny][nx] = clonedBoard[row][col];
                            clonedBoard[row][col] = 0;
                        } else {
                            int temp = clonedBoard[ny][nx];
                            Fish nextFish = fishes[temp];
                            nextFish.row = row;
                            nextFish.col = col;
                            clonedBoard[ny][nx] = clonedBoard[row][col];
                            clonedBoard[row][col] = temp;
                        }
                        fish.row = ny;
                        fish.col = nx;
                        fish.direct = direct;
                        break;
                    }
                }
            }
        }
        return clonedBoard;
    }

    public static int dfs(int[][] board, Fish[] fishes, int row, int col, int direct, int sum) {

        //물고기 움직이기.
        Fish[] clonedFishes = new Fish[17];
        for(int i=1; i<=16; i++) {
            if(fishes[i] != null) {
                clonedFishes[i] = new Fish(fishes[i].row, fishes[i].col, fishes[i].direct);
            }

        }
        int[][] rotateBoard = moveFish(board, clonedFishes);


        //상어 움직이기.
        int nx = col + moveX[direct % 8];
        int ny = row + moveY[direct % 8];


        int result = sum;
        //상어가 움직일 수 없는 조건
        //1. 가려는 방향에 물고기가 업는 경우
        //2. 경계선을 벗어난 경우.
        while (nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
            if (rotateBoard[ny][nx] != 0) {
                int deadFishNumber = rotateBoard[ny][nx];
                Fish deadFish = clonedFishes[deadFishNumber];

                rotateBoard[row][col] = 0;
                rotateBoard[ny][nx] = -1;
                clonedFishes[deadFishNumber] = null;
                result = Math.max(result, dfs(rotateBoard, clonedFishes, ny, nx, deadFish.direct, sum+deadFishNumber));
                rotateBoard[row][col] = -1;
                rotateBoard[ny][nx] = deadFishNumber;
                clonedFishes[deadFishNumber] = deadFish;
            }
            nx += moveX[direct % 8];
            ny += moveY[direct % 8];
        }
        return result;
    }


}
