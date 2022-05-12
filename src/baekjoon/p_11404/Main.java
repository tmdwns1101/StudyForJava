package baekjoon.p_11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    private static final int INF = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] distance = new int[n][n];
        for(int i=0; i<n; i++) {
            Arrays.fill(distance[i], INF);
            distance[i][i] = 0;
        }

        for(int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            distance[a][b] = Math.min(distance[a][b],cost);
        }

        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        Arrays.stream(distance).forEach(row -> {
            String result = Arrays.stream(row).map(elem -> elem == INF ? 0 : elem).mapToObj(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(result);
        });
    }
}
