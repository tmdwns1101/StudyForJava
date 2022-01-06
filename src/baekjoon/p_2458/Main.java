package baekjoon.p_2458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] table = new char[n][n];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int less = Integer.parseInt(st.nextToken())-1;
            int grater = Integer.parseInt(st.nextToken())-1;
            table[less][grater] = 'L';
            table[grater][less] = 'G';
        }

        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(table[i][k] == 'G' && table[k][j] == 'G') {
                        table[i][j] = 'G';
                    }
                    if(table[i][k] == 'L' && table[k][j] == 'L') {
                        table[i][j] = 'L';
                    }
                }
            }
        }

        int answer = 0;
        for(char[] row: table) {
            long count = String.valueOf(row).chars().filter(c -> c == 'L' || c == 'G').count();
            if(count == n-1) {
                answer++;
            }
        }
        System.out.println(answer);

    }
}
