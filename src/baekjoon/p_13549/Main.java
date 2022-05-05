package baekjoon.p_13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 숨바꼭질3 - 13549
 * */
public class Main {

    private static final int MAX_RANGE = 100001;

    static class Position implements Comparable<Position> {
        int pos;
        int time;

        public Position(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }

        @Override
        public int compareTo(Position o) {
            return Integer.compare(this.time, o.time);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Position> queue = new PriorityQueue<>();
        boolean[] isVisited = new boolean[MAX_RANGE];

        queue.offer(new Position(n, 0));
        int answer = MAX_RANGE;
        while (!queue.isEmpty()) {
            Position front = queue.poll();
            int pos = front.pos;
            int time = front.time;

            isVisited[pos] = true;

            if (pos == k) {
                answer = time;
                break;
            }

            if (pos * 2 < MAX_RANGE && !isVisited[pos * 2]) {
                queue.offer(new Position(pos * 2, time));
            }
            if (pos + 1 < MAX_RANGE && !isVisited[pos + 1]) {
                queue.offer(new Position(pos + 1, time + 1));
            }
            if (pos - 1 >= 0 && !isVisited[pos - 1]) {
                queue.offer(new Position(pos - 1, time + 1));
            }

        }
        System.out.println(answer);
    }
}
