package baekjoon.p_7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 7562
 * 나이트의 이동
 * */
public class Main {
    private static int[][] move = {
            {-2,1},
            {-1,2},
            {1,2},
            {2,1},
            {2,-1},
            {1,-2},
            {-1,-2},
            {-2,-1}
    };

    static class Night {
        int row;
        int col;
        int count;

        public Night(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int t=0; t<tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] nightPos = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] targetPos =  Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int answer = bfs(nightPos,targetPos, n);
            System.out.println(answer);
        }
    }

    private static int bfs(int[] nightPos, int[] targetPos, int n) {
        Queue<Night> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[n][n];
        queue.offer(new Night(nightPos[0],nightPos[1],0));
        isVisited[nightPos[0]][nightPos[1]] = true;
        int count = -1;
        while(!queue.isEmpty()) {
            Night night = queue.poll();
            if(night.row == targetPos[0] && night.col == targetPos[1]){
                count = night.count;
                break;
            }

            for (int[] m : move) {
                int nextRow = night.row + m[0];
                int nextCol = night.col + m[1];

                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n && !isVisited[nextRow][nextCol]) {
                    queue.offer(new Night(nextRow, nextCol, night.count + 1));
                    isVisited[nextRow][nextCol] = true;
                }
            }
        }
        return count;
    }
}
