package baekjoon.p_1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/**
 * 알고스팟 - 1261
 * */
public class Main {

    private static final int[][] directions = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };

    private static class Node implements Comparable<Node>{
        int row;
        int col;
        int depth;

        public Node(int row, int col, int depth) {
            this.row = row;
            this.col = col;
            this.depth = depth;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.depth, o.depth);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];

        for(int i=0; i<n; i++) {
            board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        boolean[][] isVisited = new boolean[n][m];

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(0,0,0));
        isVisited[0][0] = true;

        int answer = 0;
        while(!queue.isEmpty()) {
            Node front = queue.poll();
            if(front.row == n -1 && front.col == m - 1) {
                answer = front.depth;
                break;
            }
            for(int[] dir: directions) {
                int nextRow = front.row + dir[0];
                int nextCol = front.col + dir[1];
                if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && !isVisited[nextRow][nextCol]) {
                    isVisited[nextRow][nextCol] = true;
                    int nextDepth = front.depth;
                    if(board[nextRow][nextCol] == 1) {
                        nextDepth++;
                    }
                    queue.offer(new Node(nextRow, nextCol, nextDepth));
                }

            }
        }

        System.out.println(answer);

    }
}
