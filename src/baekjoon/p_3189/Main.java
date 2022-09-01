package baekjoon.p_3189;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* 백준 3189
* 양치기 꿍
* */
public class Main {

    private static int wCount;
    private static int sCount;
    private static char[][] board;
    private static int N;
    private static int M;
    private static final int[][] mv = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        boolean[][] isVisited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            board[i] = br.readLine().toCharArray();
            for(int j=0; j<M; j++) {
                if(board[i][j] == 'v') wCount++;
                if(board[i][j] == 'k') sCount++;
                if(board[i][j] == '#') isVisited[i][j] = true;
            }
        }


        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!isVisited[i][j]) {
                    isVisited[i][j] = true;
                    solve(i,j,isVisited);
                }
            }
        }

        System.out.println(sCount+" "+wCount);
    }

    private static void solve(int row, int col, boolean[][] isVisited) {
        Queue<int[]> queue = new LinkedList<>();
        int wolf = 0;
        int sheep = 0;
        queue.offer(new int[] {row, col});

        while(!queue.isEmpty()) {
            int[] front = queue.poll();
            int r = front[0];
            int c = front[1];
            if(board[r][c] == 'v') wolf++;
            if(board[r][c] == 'k') sheep++;
            for(int i=0; i<4;i++) {
                int nr = r + mv[i][0];
                int nc = c + mv[i][1];
                if(nr >= 0 && nr < N && nc >=0 && nc < M && !isVisited[nr][nc]) {
                    queue.offer(new int[]{nr,nc});
                    isVisited[nr][nc] = true;
                }

            }
        }

        if(sheep > wolf) wCount -= wolf;
        else sCount -= sheep;
    }
}
