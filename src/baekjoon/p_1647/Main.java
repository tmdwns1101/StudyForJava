package baekjoon.p_1647;

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> nodes = new PriorityQueue<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes.offer(new Node(a,b,c));
        }

        int[] parent = new int[n+1];

        for(int i=1; i<=n; i++) {
            parent[i] = i;
        }

        int answer = 0;
        int maxDistance = 0;
        while(!nodes.isEmpty()) {
            Node node = nodes.poll();

            if(!isSameUnion(parent,node.left,node.right)) {
                union(parent,node.left, node.right);
                answer += node.distance;
                maxDistance = Math.max(maxDistance, node.distance);
            }
        }

        answer -= maxDistance;
        System.out.println(answer);

    }


    public static int find(int[] parent, int target) {
       if(parent[target] == target) return target;
       else return parent[target] = find(parent, parent[target]);
    }
    public static void union(int[] parent, int a, int b) {
       int aParent = find(parent, a);
       int bParent = find(parent, b);
       if(aParent < bParent) parent[bParent] = aParent;
       else parent[aParent] = bParent;
    }

    public static boolean isSameUnion(int[] parent, int a, int b) {
        int aParent = find(parent, a);
        int bParent = find(parent, b);
        return aParent == bParent;
    }
}
