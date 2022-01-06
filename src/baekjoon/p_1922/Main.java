package baekjoon.p_1922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node>{
        int left;
        int right;
        int distance;

        Node(int left, int right, int distance) {
            this.left = left;
            this.right = right;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        PriorityQueue<Node> queue = new PriorityQueue<>();

        for(int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken())-1;
            int right = Integer.parseInt(st.nextToken())-1;
            int distance = Integer.parseInt(st.nextToken());
            queue.offer(new Node(left, right, distance));
        }

        int[] parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }

        int answer = 0;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(!isSameParent(parent,node.left, node.right)) {
                answer += node.distance;
                union(parent, node.left, node.right);
            }
        }
        System.out.println(answer);

    }

    private static int find(int[] parent, int target) {
        if(parent[target] == target) return target;
        else return parent[target] = find(parent, parent[target]);
    }
    private static void union(int[] parent, int a, int b) {
        int aParent = find(parent, a);
        int bParent = find(parent, b);
        if(aParent < bParent) parent[bParent] = aParent;
        else parent[aParent] = bParent;
    }
    private static boolean isSameParent(int[] parent, int a, int b) {
        return find(parent, a) == find(parent, b);
    }
}
