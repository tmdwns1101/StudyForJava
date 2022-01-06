package baekjoon.p_1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int INF = 100000000;

    private static class Node implements Comparable<Node>{
        int to;
        int distance;

        public Node(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.distance, node.distance);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());



        List<List<Node>> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int distance = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(to, distance));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;

        int[] distances = new int[n];
        Arrays.fill(distances, INF);
        int answer = 0;
        dijkstra(list, distances, a, n);
        answer = distances[b];
        System.out.println(answer);
    }

    private static void dijkstra(List<List<Node>> list, int[] distances, int start, int n) {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        boolean[] visited = new boolean[n];
        queue.offer(new Node(start, 0));
        distances[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int to = node.to;
            if(!visited[to]) {
                visited[to] = true;
                for(Node next: list.get(to)) {
                    if(distances[to] + next.distance < distances[next.to]) {
                        distances[next.to] = distances[to] + next.distance;
                        queue.offer(new Node(next.to, distances[next.to]));
                    }
                }
            }
        }
    }
}
