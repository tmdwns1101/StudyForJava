package baekjoon.p_21278;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * 호석이 두 마리 치킨 - 21278
 * */
public class Main {

    private static final int INF = 100000000;

    private static int n;
    private static int m;

    private static int[][] distance;


    private static class Delivery implements Comparable<Delivery> {

        int buildingNumber;
        int distance;

        public Delivery(int buildingNumber, int distance) {
            this.buildingNumber = buildingNumber;
            this.distance = distance;
        }

        @Override
        public int compareTo(Delivery o) {
            return Integer.compare(this.distance, o.distance);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        distance = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], INF);
            distance[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            distance[a][b] = 1;
            distance[b][a] = 1;
        }

        floydWarshall(distance);
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int result = bfs(distance, i, j);
                list.add(new int[]{i + 1, j + 1, result});
            }
        }
        list.sort((o1, o2) -> {
            if (o1[2] != o2[2]) {
                return Integer.compare(o1[2], o2[2]);
            }
            else if (o1[0] != o2[0]) {
                return Integer.compare(o1[0], o2[0]);
            } else {
                return Integer.compare(o1[1],o2[1]);
            }
        });

        int[] answer = list.get(0);
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }



    private static void floydWarshall(int[][] distance) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
    }

    private static int bfs(int[][] distance, int store1, int store2) {
        int result = 0;

        PriorityQueue<Delivery> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.offer(new Delivery(i, distance[store1][i]));
            queue.offer(new Delivery(i, distance[store2][i]));
        }

        boolean[] isVisited = new boolean[n];
        isVisited[store1] = true;
        isVisited[store2] = true;

        while (!queue.isEmpty()) {
            Delivery front = queue.poll();
            if (!isVisited[front.buildingNumber]) {
                isVisited[front.buildingNumber] = true;
                result += (front.distance * 2);
            }
        }
        return result;
    }
}
