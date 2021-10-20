package baekjoon.p_1726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] moveX = {1,-1,0,0};
    static int[] moveY = {0,0,1,-1};

    static class Node implements Comparable<Node>{
        int row;
        int col;
        int direct;
        int count;

        Node(int row, int col, int direct, int count) {
            this.row = row;
            this.col = col;
            this.direct = direct;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            int count = o.count;
            return Integer.compare(this.count, count);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        Node start = new Node(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1,0);
        st = new StringTokenizer(br.readLine());
        Node end = new Node(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1,0);

        Node result = bfs(board,start,end,n,m);
        int answer = result.count;
        int direct = result.direct;
        if(direct != end.direct) {
            if(direct == 0) {
                if(end.direct == 1) answer += 2;
                else answer += 1;
            }
            else if(direct == 1) {
                if(end.direct == 0) answer += 2;
                else answer += 1;
            }
            else if(direct == 2) {
                if(end.direct == 3) answer += 2;
                else answer += 1;
            }
            else {
                if(end.direct == 2) answer += 2;
                else answer += 1;
            }
        }
        System.out.println(answer);
    }

    static Node bfs(int[][] board, Node start, Node end, int n, int m) {
        //우선순위 큐를 사용하는 이유
        //1. 목적지까지 도달하는 최소 경로 찾는 문제이면, Queue 를 사용해도 된다.
        //2. 하지만, 이 문제는 명령어 개수를 최소로 하면서 목적지 까지 도달해야 함.
        //3. 아무리 최소 경로로 도착할 수 있어도, 회전 등에 명령어로 인해 명령어 수가 증가 하게 되면, 최소의 명령어 수로 도달 할 수 없음.
        //4. 명령어 개수가 적게 이동한 경로를 우선 순위를 높인다.
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[][] visited = new boolean[n][m];
        queue.offer(start);
        visited[start.row][start.col] = true;

        while(!queue.isEmpty()) {
            Node front = queue.poll();
            int row = front.row;
            int col = front.col;
            int direct = front.direct;
            int count = front.count;
            if(row == end.row && col == end.col) {
                return front;
            }
            for(int i=0; i<4; i++) {
                int nx = col + moveX[i];
                int ny = row + moveY[i];
                int command = 1;
                if(i != direct) {
                    if(i == 0) {
                        if(direct == 1) command += 2;
                        else command += 1;
                    }
                    else if(i == 1) {
                        if(direct == 0) command += 2;
                        else command += 1;
                    }
                    else if(i == 2) {
                        if(direct == 3) command += 2;
                        else command += 1;
                    }
                    else {
                        if(direct == 2) command += 2;
                        else command += 1;
                    }
                }
                for(int j=0; j<3; j++) {
                    if(nx >= 0 && nx < m && ny >=0 && ny < n && !visited[ny][nx] && board[ny][nx] != 1) {
                        queue.offer(new Node(ny,nx,i,count+command));
                        visited[ny][nx] = true;
                    }
                    if(nx >= 0 && nx < m && ny >=0 && ny < n && board[ny][nx] == 1) {
                       break;
                    }
                    nx += moveX[i];
                    ny += moveY[i];
                }
            }

        }
        return null;
    }
}
