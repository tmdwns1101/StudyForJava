package baekjoon.p_2665;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] moveX = {1, -1, 0, 0};
    static int[] moveY = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            board[i] = row;
        }

        Queue<int[]> queue = new LinkedList<>();

        int[][] costs = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                costs[i][j] = Integer.MAX_VALUE;
            }
        }

        int answer = Integer.MAX_VALUE;
        queue.offer(new int[]{0, 0, 0});
        costs[0][0] = 0;
        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            int row = front[0];
            int col = front[1];
            int cost = front[2];
            if (row == n - 1 && col == n - 1) {
                answer = Math.min(answer, cost);
            }
            //(n-1,n-1) 도착했을 때 최소로 부순 횟수보다 지금 까지 탐색하면서 온경로에서 부순 횟수가 더 크거나 같다면 더 이상 탐색 할 필요 없음.
            if (cost < answer) {
                for (int i = 0; i < 4; i++) {
                    int nx = col + moveX[i];
                    int ny = row + moveY[i];
                    //1. NxN 범위 벗어나면 안됨.
                    //2. 이동할려는 곳이 지금까지 검은 방을 흰 방으로 바꾼 횟수보다 클 경우에만 이동.(만약 작거나 같다면, 이미 그 곳은 다른 경로에서 최소한으로 검은 방을 흰방으로 바꾸고 이동하였음.)
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && cost < costs[ny][nx]) {
                        int[] item = new int[3];
                        item[0] = ny;
                        item[1] = nx;
                        item[2] = cost;
                        if (board[ny][nx] == 0) {     //다음에 탐색할 방이 검은 방 일 경우
                            item[2]++;
                        }
                        queue.offer(item);
                        costs[ny][nx] = item[2];
                    }
                }
            }
        }
        System.out.println(answer);

    }
}
