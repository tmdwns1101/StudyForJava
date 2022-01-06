package baekjoon.p_1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private final static int[][] direct = {
            {0,0},
            {0,1},
            {1,0},
            {1,1}
    };
    private static int r;
    private static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        divide(n, 0,0,0);

    }

    private static void divide(int n, int start, int row, int col) {
        if(n == 0) {
            if(row == r && col == c) System.out.println(start);
        }
        else {
            int dividePivot = (int)(Math.pow(2, n) * Math.pow(2,n)) / 4;
            int nextSize = (int)Math.pow(2,n-1);
            for(int i=0; i<4; i++) {
                int nextValue = start + dividePivot*i;
                int nextStartRow = row+nextSize*direct[i][0];
                int nextStartCol = col+nextSize*direct[i][1];
                if(nextStartRow <= r && r <= nextStartRow+nextSize-1 && nextStartCol <= c && c <= nextStartCol+nextSize-1) divide(n-1, nextValue, nextStartRow, nextStartCol);
            }
        }
    }
}
