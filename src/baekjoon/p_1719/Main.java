package baekjoon.p_1719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * 택배 - 1719
 * */
public class Main {

    private static final int INF = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] distance = new int[n][n];
        for(int i=0; i<n; i++ ){
            Arrays.fill(distance[i], INF);
            distance[i][i] = 0;
        }

        int[][] parent = new int[n][n];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            distance[a][b] = cost;
            distance[b][a] = cost;

            //최초 경로지 설정
            parent[a][b] = b+1;
            parent[b][a] = a+1;
        }

        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        parent[i][j] = parent[i][k]; //최초 경로지(root) 업데이트
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int[] row: parent) {
                String result = Arrays.stream(row).mapToObj(elem -> elem == 0 ? "-" : String.valueOf(elem)).collect(Collectors.joining(" "));
                sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}
