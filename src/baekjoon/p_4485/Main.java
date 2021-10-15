package baekjoon.p_4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] moveX = {1,-1,0,0};
    static int[] moveY = {0,0,1,-1};

    static class Node implements Comparable<Node>{
        int number;
        int weight;

        Node(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.weight, node.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int pNum = 1;
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            Node[][] board = new Node[n][n];

            int number = 0;
            for(int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) {
                    board[i][j] = new Node(number, Integer.parseInt(st.nextToken()));
                    number++;
                }
            }

            //각 노드별 연결 정보 초기화
            List<List<Node>> nodes = new ArrayList<>();
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    List<Node> now = new ArrayList<>();
                    for(int k=0; k<4; k++) {
                        int nx = j + moveX[k];
                        int ny = i + moveY[k];
                        if(nx >=0 && nx < n && ny >= 0 && ny < n) {
                            now.add(board[ny][nx]);
                        }
                    }
                    nodes.add(now);
                }
            }
            int answer = dijkstra(board, nodes, n, 0, 0);
            System.out.println("Problem "+pNum+": "+ answer);
            pNum++;

        }
    }

    public static int dijkstra(Node[][] board, List<List<Node>> nodes, int n, int row, int col) {
        int answer = 0;

        //각 노드에 도착하는 최소 비용.
        int[] w = new int[n*n];
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        int start = row*n+col;

        answer = board[row][col].weight;
        w[start] = 0;

        for(int i=1; i<w.length; i++) {
            w[i] = Integer.MAX_VALUE;
        }

        priorityQueue.offer(new Node(start, 0));

        while(!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            int now = node.number;
            int weight = node.weight;
            if(w[now] < weight) continue;
            for(Node next: nodes.get(now)) {
                int nextWeight = weight + next.weight;
                if(nextWeight < w[next.number]) {
                    w[next.number] = nextWeight;
                    priorityQueue.offer(new Node(next.number, nextWeight));
                }
            }
        }
        return answer+w[n*n-1];
    }
}
