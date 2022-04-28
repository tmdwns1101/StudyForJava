package baekjoon.p_2660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 2660
 * 회장 뽑기
 * */
public class Main {

    private static final int INF = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] graph = new int[n][n];

        for(int i=0; i<n; i++) {
            Arrays.fill(graph[i],INF);
            graph[i][i] = 0;
        }

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int member1 = Integer.parseInt(st.nextToken());
            int member2 = Integer.parseInt(st.nextToken());
            if(member1 == -1 && member2 == -1) break;

            graph[member1-1][member2-1] = 1;
            graph[member2-1][member1-1] = 1;
        }

        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        int[] valueArr = new int[n];
        int candidateValue = INF;

        for(int i=0; i<n; i++) {
            int value = Arrays.stream(graph[i]).max().orElse(INF+1);
            valueArr[i] = value;

            if(value < candidateValue) {
                candidateValue = value;
            }
        }
        StringBuilder answer = new StringBuilder();
        int candidateCount = 0;
        for(int i=0; i<n; i++) {
            if(valueArr[i] == candidateValue) {
                answer.append(i+1);
                answer.append(" ");
                candidateCount++;
            }
        }

        System.out.println(candidateValue + " " + candidateCount);
        System.out.println(answer.toString().trim());
    }
}
