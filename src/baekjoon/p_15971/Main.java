package baekjoon.p_15971;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 두 로봇 - 15971
 * */
public class Main {

    private static int[] dist;
    private static int[] maxV;
    private static boolean[] isVisited;

    static class Pair {
        int number;
        int weight;

        public Pair(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int robotA = Integer.parseInt(st.nextToken()) - 1;
        int robotB = Integer.parseInt(st.nextToken()) - 1;

        List<List<Pair>> nodes = new ArrayList<>();

        dist = new int[n];
        maxV = new int[n];
        isVisited = new boolean[n];

        for (int i = 0; i < n; i++) nodes.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int roomA = Integer.parseInt(st.nextToken()) - 1;
            int roomB = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());

            nodes.get(roomA).add(new Pair(roomB, weight));
            nodes.get(roomB).add(new Pair(roomA, weight));
        }

        dfs(nodes, robotA, 0, 0);
        int answer = dist[robotB] - maxV[robotB];
        System.out.println(answer);
    }

    private static void dfs(List<List<Pair>> nodes, int start, int sum, int maxWeight) {
        dist[start] = sum;
        maxV[start] = maxWeight;
        isVisited[start] = true;
        List<Pair> list = nodes.get(start);
        for (Pair next : list) {
            int number = next.number;
            int weight = next.weight;
            if (!isVisited[number]) {
                dfs(nodes, number, sum + weight, Math.max(maxWeight, weight));
            }
        }
    }
}
