package baekjoon.p_1516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 - 1516
 * 게임 개발
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n;i++) {
            list.add(new ArrayList<>());
        }

        int[] time = new int[n];
        int[] depth = new int[n];

        for(int i=0; i<n; i++) {
            int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            time[i] = info[0];
            for(int k=1; k< info.length; k++) {
                if(info[k] != -1) {
                    int prevNeed = info[k] - 1;
                    list.get(prevNeed).add(i);
                    depth[i]++;
                }
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i=0; i<n; i++) {
            if(depth[i] == 0) {
                queue.offer(i);
            }
        }

        int[] answer = new int[n];

        while(!queue.isEmpty()) {
            int front = queue.poll();
            answer[front] += time[front];
            List<Integer> buildings = list.get(front);
            for(int building: buildings) {
                depth[building]--;

                if(depth[building] == 0) {
                    queue.offer(building);
                }
                answer[building] = Math.max(answer[building], answer[front]);
            }
        }

        Arrays.stream(answer).forEach(System.out::println);
    }
}
