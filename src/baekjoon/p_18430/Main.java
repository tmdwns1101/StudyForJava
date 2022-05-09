package baekjoon.p_18430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 무기 공학 - 18430
 * */
public class Main {

    private static final int[][] directions = {
            {-1,1},
            {1,1},
            {1,-1},
            {-1,-1}
    };

    private static int n;
    private static int m;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];

        for(int i=0; i<n; i++){
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        boolean[][] isVisited = new boolean[n][m];
        int answer = dfs(board,isVisited,0,0);
        System.out.println(answer);


    }

    private static int dfs(int[][] board, boolean[][] isVisited,int x, int sum) {
        int result = sum;

        for(int i=0; i<n; i++) {
            for(int j=x; j<m; j++) { //x 이전 열은 이미 탐색을 했으므로, 0부터 다시 중복해서 탐색 할 필요가 없다.
                if(!isVisited[i][j]) {
                    isVisited[i][j] = true;
                    for(int[] dir: directions) {
                        int wingA = i + dir[0];
                        int wingB = j + dir[1];
                        if(wingA >=0 && wingA < n && wingB >= 0 && wingB < m && !isVisited[wingA][j] && !isVisited[i][wingB]) {
                            isVisited[wingA][j] = true;
                            isVisited[i][wingB] = true;
                            int weight = board[i][j] * 2 + board[wingA][j] + board[i][wingB];
                            result = Math.max(result,dfs(board, isVisited, j,sum+weight));
                            isVisited[wingA][j] = false;
                            isVisited[i][wingB] = false;
                        }
                    }
                    isVisited[i][j] = false;
                }
            }
        }

        return result;
    }
}
