package baekjoon.p_4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] directions = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };

    static class Jihun {
        int row;
        int col;
        int moveCount;
        public Jihun(int row, int col, int moveCount) {
            this.row = row;
            this.col = col;
            this.moveCount = moveCount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] miro = new char[r][c];


        Queue<Jihun> jQueue = new LinkedList<>();
        Queue<int[]> fQueue = new LinkedList<>();
        for(int i=0; i<r; i++) {
            char[] row = br.readLine().toCharArray();
            for(int j=0; j<row.length; j++) {
                if(row[j] == 'J') {
                    jQueue.offer(new Jihun(i,j,0));
                };
                if(row[j] == 'F') {
                    int[] fire = new int[]{i,j};
                    fQueue.offer(fire);
                }
            }
            miro[i] = row;
        }

        int answer = -1;


        while(!fQueue.isEmpty() || !jQueue.isEmpty()) {

            List<int[]> tempF = new LinkedList<>();
            while(!fQueue.isEmpty()) {
                int[] fire = fQueue.poll();
                for(int[] dir: directions) {
                    int nextRow = fire[0] + dir[0];
                    int nextCol = fire[1] + dir[1];

                    if(nextRow >= 0 && nextRow < r && nextCol >= 0 && nextCol < c && (miro[nextRow][nextCol] == '.' || miro[nextRow][nextCol] == 'J')) {
                        miro[nextRow][nextCol] = 'F';
                        tempF.add(new int[]{nextRow,nextCol});
                    }
                }
            }
            fQueue.addAll(tempF);
            tempF = null;

            List<Jihun> tempJ = new LinkedList<>();
            while(!jQueue.isEmpty()) {
                Jihun jihun = jQueue.poll();
                if(jihun.row == 0 || jihun.row == r -1 || jihun.col == 0 || jihun.col == c - 1){
                    answer = jihun.moveCount + 1;
                    break;
                }
                for(int[] dir: directions) {
                    int nextRow = jihun.row + dir[0];
                    int nextCol = jihun.col + dir[1];

                    if(nextRow >= 0 && nextRow < r && nextCol >= 0 && nextCol < c && miro[nextRow][nextCol] == '.') {
                        miro[nextRow][nextCol] = 'J';
                        tempJ.add(new Jihun(nextRow,nextCol, jihun.moveCount+1));
                    }
                }
            }
            jQueue.addAll(tempJ);
            tempJ = null;
            if(answer != -1) break;

        }

        if(answer != -1) {
            System.out.println(answer);
        } else {
            System.out.println("IMPOSSIBLE");
        }


    }
}
