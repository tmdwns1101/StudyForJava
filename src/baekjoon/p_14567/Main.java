package baekjoon.p_14567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> relations = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            relations.add(new ArrayList<>());
        }

        int[] degrees = new int[n];
        int[] depth = new int[n];
        Arrays.fill(depth, 1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken()) - 1;
            int next = Integer.parseInt(st.nextToken()) - 1;
            relations.get(pre).add(next);
            degrees[next]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degrees[i] == 0) {
                queue.offer(i);
            }
        }

        //위상정렬
        while (!queue.isEmpty()) {
            int now = queue.poll();
            List<Integer> relationSubjects = relations.get(now);
            for (int nextSubject : relationSubjects) {
                degrees[nextSubject]--;
                depth[nextSubject] = Math.max(depth[nextSubject], depth[now] + 1);
                if (degrees[nextSubject] == 0) {
                    queue.offer(nextSubject);
                }
            }
        }
        System.out.println(Arrays.stream(depth).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
