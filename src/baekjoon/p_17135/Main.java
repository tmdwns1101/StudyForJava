package baekjoon.p_17135;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] board;
    private static int n;
    private static int m;
    private static int d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] archers = new int[3];
        int answer = solution(0, 0, archers);
        System.out.println(answer);

    }


    private static int solution(int size, int start, int[] archers) {
        if (size == 3) {
            return attack(archers);
        } else {
            int answer = 0;
            for (int i = start; i < m; i++) {
                archers[size] = i;
                answer = Math.max(answer,solution(size + 1, i+1, archers));
            }
            return answer;
        }
    }

    private static int attack(int[] archers) {
        int count = 0;
        boolean[][] visited = new boolean[n][m];


        for (int k = n - 1; k >= 0; k--) {
            int[][] removePositions = new int[archers.length][2];
            for (int z=0; z<archers.length; z++) {
                int archer = archers[z];
                int minDist = Integer.MAX_VALUE;
                int dr = 0;
                int dc = 0;
                for (int i = 0; i <= k; i++) {
                    for (int j = 0; j < m; j++) {
                        if (board[i][j] == 1 && !visited[i][j]) {
                            int r1 = i + (n - 1 - k);
                            int dist = Math.abs(r1 - n) + Math.abs(j - archer);
                            if (dist <= d) {
                                if (dist < minDist) {
                                    minDist = dist;
                                    dr = i;
                                    dc = j;
                                }
                                if (dist == minDist && j < dc) {
                                    dr = i;
                                    dc = j;
                                }
                            }
                        }
                    }
                }
                removePositions[z] = new int[]{minDist, dr, dc};

            }
            for(int[] removePos: removePositions) {
                int minDist = removePos[0];
                int dr = removePos[1];
                int dc = removePos[2];
                if (minDist != Integer.MAX_VALUE && !visited[dr][dc]) {
                    visited[dr][dc] = true;
                    count++;
                }
            }

        }


        return count;
    }
}
