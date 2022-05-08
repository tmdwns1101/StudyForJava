package baekjoon.p_13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * ABCDE - 13023
 * */
public class Main {

    private static int n;
    private static int m;
    private static int answer;
    private static boolean isFind = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<List<Integer>> nodes = new ArrayList<>();
        for(int i=0; i<n; i++) {
            nodes.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            nodes.get(left).add(right);
            nodes.get(right).add(left);
        }

        boolean[] isVisited = new boolean[n];
        for(int i=0; i<n; i++) {
            isVisited[i] = true;
            dfs(nodes, isVisited, i, 1);
            isVisited[i] = false;
        }
        System.out.println(answer);
    }

    private static void dfs(List<List<Integer>> nodes, boolean[] isVisited,int start, int count) {
        if(count == 5){
            isFind = true;
            answer = 1;
        } else {
            List<Integer> current = nodes.get(start);

            for(int next: current) {
                if(!isVisited[next] && !isFind){
                    isVisited[next] = true;
                    dfs(nodes, isVisited, next, count+1);
                    isVisited[next] = false;
                }
            }
        }
    }
}
