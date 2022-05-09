package baekjoon.p_18513;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int[] direction = {-1,1};

    static class Position {
        int pos;
        int distance;

        public Position(int pos, int distance) {
            this.pos = pos;
            this.distance = distance;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] springLocations = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Queue<Position> queue = new LinkedList<>();

        Set<Integer> isVisited = new HashSet<>();
        for(int loc: springLocations) {
            queue.offer(new Position(loc, 0));
            isVisited.add(loc);
        }

        long answer = 0; //1 + 2+ ... + N(100000) 까지이므로, int 자료형 범위가 초과되므로, long 사용
        int count = 0;
        while(!queue.isEmpty()) {
            Position position = queue.poll();

            for(int dir: direction) {
                int next = position.pos + dir;
                if(!isVisited.contains(next) && count < k) {
                    queue.offer(new Position(next, position.distance+1));
                    isVisited.add(next);
                    answer += position.distance+1;
                    count++;
                }
            }
        }

        System.out.println(answer);
    }
}
