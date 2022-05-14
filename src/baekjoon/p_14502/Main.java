package baekjoon.p_14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 연구소 - 14502
 * */
public class Main {

    private static int n;
    private static int m;

    private static int initWallCount;

    private static List<int[]> virusLocations = new ArrayList<>();
    private static final int[][] directions = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];

        for(int i=0; i<n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<m; j++) {
                if(board[i][j] == 2) virusLocations.add(new int[]{i,j});
                if(board[i][j] == 1) initWallCount++;
            }
        }
        int answer = dfs(board, 0,0);
        
        System.out.println(answer);
    }

    private static int dfs(int[][] board, int start, int count) {
        if(count >= 3) {
            return n*m - (initWallCount+3) - spreadVirusCounting(board); //총 칸의 개수 - 벽의 개수 - 바이러스가 퍼진 칸의 개수 = 안전한 구역의 넓이(칸의 개수)
        } else {
            int result = -1;
            for(int i=start; i<n*m; i++) {  // 행 * 열 = 1차원으로 길게 만든다.
                int row = i / m;  //열의 길이로 나눈 값은 행
                int col = i % m;  //열의 길이로 나눈 나머지는 열
                    if(board[row][col] == 0) {
                        board[row][col] = 1;
                        result = Math.max(result, dfs(board, i+1,count+1));
                        board[row][col] = 0;
                    }
            }
            return result;
        }
    }

    private static int spreadVirusCounting(int[][] board) {
        int count = 0;
        boolean[][] isVisited = new boolean[n][m];
        for(int[] virus: virusLocations) {
            int row = virus[0];
            int col = virus[1];
            if(!isVisited[row][col]) {
                count += bfs(board, isVisited, row, col);
            }
        }
        return count;
    }

    private static int bfs(int[][] board, boolean[][] isVisited, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row,col});
        isVisited[row][col] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            int r = front[0];
            int c = front[1];
            count++;
            for(int[] dir: directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && !isVisited[nr][nc] && board[nr][nc] == 0){
                    isVisited[nr][nc] = true;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }
        return count;
    }
}
