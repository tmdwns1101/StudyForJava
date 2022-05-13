package baekjoon.p_18405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 경쟁적 전염 - 18405
 * */
public class Main {

    private static final int[][] directinos = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };

    private static class Virus implements Comparable<Virus>{
        int number;
        int row;
        int col;

        public Virus(int number, int row, int col) {
            this.number = number;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Virus o) {
            return Integer.compare(this.number, o.number);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][n];

        PriorityQueue<Virus> queue = new PriorityQueue<>();
        boolean[][] isVisited = new boolean[n][n];
        for(int i=0; i<n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<n; j++) {
                if(board[i][j] != 0) {
                    queue.offer(new Virus(board[i][j], i, j));
                    isVisited[i][j] = true;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        while(s-- > 0){

            List<Virus> temp = new ArrayList<>();
            while (!queue.isEmpty()) {
                Virus virus = queue.poll();

                for(int[] dir: directinos) {
                    int nr = virus.row + dir[0];
                    int nc = virus.col + dir[1];
                    if(nr >= 0 && nr <n && nc >= 0 && nc < n && !isVisited[nr][nc]){
                        isVisited[nr][nc] = true;
                        temp.add(new Virus(virus.number, nr,nc));
                        board[nr][nc] = virus.number;
                    }
                }
            }
            for(Virus virus: temp) queue.offer(virus);
        }


        System.out.println(board[x-1][y-1]);

    }
}
