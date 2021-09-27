package baekjoon.goodbyedust;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] moveX = {1, -1, 0, 0};
    static int[] moveY = {0, 0, 1, -1};


    public static void main(String[] args) throws Exception {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(sb.readLine());
        int r = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());
        int t = Integer.parseInt(stringTokenizer.nextToken());

        int[][] board = new int[r][c];


        //공기 청정기 행 (위쪽, 아래쪽)
        int[] airCleaner = new int[2];

        int k = 0;
        for (int i = 0; i < r; i++) {
            int[] row = Arrays.stream(sb.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            board[i] = row;
            for (int j = 0; j < c; j++) {
                if (row[j] == -1) {
                    airCleaner[k] = i;
                    k++;
                }
            }
        }


        while (t > 0) {

            //먼지 확산
            int[][] temp = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (board[i][j] != -1 && board[i][j] != 0) {
                        int amount = board[i][j];
                        for (int z = 0; z < 4; z++) {
                            int nx = j + moveX[z];
                            int ny = i + moveY[z];
                            if (nx >= 0 && nx < c && ny >= 0 && ny < r && board[ny][nx] != -1) {
                                int spread = amount / 5;
                                temp[ny][nx] += spread;
                                board[i][j] -= spread;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    board[i][j] += temp[i][j];
                }
            }


            //회전
            rotateTopWind(airCleaner[0], board, c);
            rotateBottomWind(airCleaner[1], board, r, c);

            t--;
        }

        int answer = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] != -1) answer += board[i][j];
            }
        }
        System.out.println(answer);
    }

    static void rotateTopWind(int row, int[][] board, int c) {
        //위쪽 공기 청정기
        int x = 0;
        int y = row - 1;

        //왼쪽
        while (y > 0) {
            board[y][x] = board[y - 1][x];
            y--;
        }
        //위쪽
        while (x < c - 1) {
            board[y][x] = board[y][x + 1];
            x++;
        }
        //오른쪽
        while (y < row) {
            board[y][x] = board[y + 1][x];
            y++;
        }
        //아래쪽
        while (x > 1) {
            board[y][x] = board[y][x - 1];
            x--;
        }
        board[y][x] = 0;
    }

    static void rotateBottomWind(int row, int[][] board, int r, int c) {
        int x = 0;
        int y = row + 1;
        //왼쪽
        while (y < r - 1) {
            board[y][x] = board[y + 1][x];
            y++;
        }
        //아래쪽
        while (x < c - 1) {
            board[y][x] = board[y][x + 1];
            x++;
        }
        //오른쪽
        while (y > row) {
            board[y][x] = board[y - 1][x];
            y--;
        }
        //위쪽
        while (x > 1) {
            board[y][x] = board[y][x - 1];
            x--;
        }
        board[y][x] = 0;
    }
}
