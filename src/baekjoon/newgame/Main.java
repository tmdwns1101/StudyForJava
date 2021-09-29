package baekjoon.newgame;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] moveX = {1, -1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};

    static class Piece {
        int number;
        int row;
        int col;
        int direct;

        Piece(int number, int row, int col, int direct) {
            this.number = number;
            this.row = row;
            this.col = col;
            this.direct = direct;
        }
    }

    public static int changeDirect(int direct) {
        if (direct == 1) return 2;
        else if (direct == 2) return 1;
        else if (direct == 3) return 4;
        else return 3;
    }

    public static void processRed(List<List<Piece>> piecesList, List<Piece> pieces, int[][] temp, int nx, int ny) {

        Collections.reverse(pieces);
        List<Piece> addList = new ArrayList<>();
        //이동하려는 칸에 아무 말이 없는 경우
        if (temp[ny][nx] == 0) {
            int under = pieces.get(0).number;
            for (Piece piece : pieces) {
                piece.row = ny;
                piece.col = nx;
                addList.add(piece);

            }
            if(pieces.size() > 1) {
                piecesList.get(under-1).addAll(addList);
                pieces.clear();
            }
            temp[ny][nx] = under;
        } else {
            for (Piece piece : pieces) {
                piece.row = ny;
                piece.col = nx;
                addList.add(piece);

            }
            piecesList.get(temp[ny][nx]-1).addAll(addList);
            pieces.clear();
        }

    }

    public static void processWhite(List<List<Piece>> piecesList, List<Piece> pieces, int[][] temp, int nx, int ny) {
        //이동하려는 칸에 아무 말도 없는 경우
        if (temp[ny][nx] == 0) {
            for (Piece piece : pieces) {
                piece.row = ny;
                piece.col = nx;
            }
            temp[ny][nx] = pieces.get(0).number;
        } else {
            List<Piece> addList = new ArrayList<>();
            for (Piece piece : pieces) {
                piece.row = ny;
                piece.col = nx;
                addList.add(piece);

            }
            piecesList.get(temp[ny][nx]-1).addAll(addList);
            pieces.clear();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][n];

        //체스판 정보 입력
        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            board[i] = row;
        }

        //1~k번 말이 순서대로 저장
        //해당 n번 말에 쌓여있는 말에 정보를 저장
        //해당 n 번말이 다른 말에 쌓여있다면, 해당 n 번말의 리스트는 비어있음.
        List<List<Piece>> piecesList = new ArrayList<>();

        //해당 위치에 땅에 닿아있는 말에 번호
        int[][] temp = new int[n][n];
        for (int i = 0; i < k; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int col = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int direct = Integer.parseInt(stringTokenizer.nextToken());
            List<Piece> pieces = new ArrayList<>();
            pieces.add(new Piece(i + 1, row, col, direct));
            piecesList.add(pieces);
            temp[row][col] = i+1;
        }

        boolean flag = true;
        int answer = 0;
        while (true) {
            for (List<Piece> pieces : piecesList) {
                if(pieces.size() >= 4) {
                    flag = false;
                }
            }
            if(answer > 1000) {
                flag = false;
                answer = -1;
            }
            if(!flag) break;

            for (List<Piece> pieces : piecesList) {

                if (!pieces.isEmpty()) {
                    Piece front = pieces.get(0);
                    int row = front.row;

                    int col = front.col;
                    int nx = col + moveX[front.direct - 1];
                    int ny = row + moveY[front.direct - 1];


                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[ny][nx] == 2) {

                        front.direct = changeDirect(front.direct);
                        int nnx = col + moveX[front.direct - 1];
                        int nny = row + moveY[front.direct - 1];
                        if (nnx >= 0 && nnx < n && nny >= 0 && nny < n && board[nny][nnx] != 2) {
                            temp[row][col] = 0;
                            if (board[nny][nnx] == 0) processWhite(piecesList, pieces, temp, nnx, nny);
                            else processRed(piecesList, pieces, temp, nnx, nny);
                        }

                    } else {
                        temp[row][col] = 0;
                        //이동하려는 칸이 흰색인 경우
                        if (board[ny][nx] == 0) {
                            processWhite(piecesList, pieces, temp, nx, ny);
                        }
                        //이동하려는 칸이 빨간색일 경우
                        if (board[ny][nx] == 1) {
                            processRed(piecesList, pieces, temp, nx, ny);
                        }

                    }
                }
            }
            answer++;
        }
        System.out.println(answer);
    }
}
