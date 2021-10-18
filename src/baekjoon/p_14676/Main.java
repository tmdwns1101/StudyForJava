package baekjoon.p_14676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<List<Integer>> relations = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            relations.add(new ArrayList<>());
        }
        int[] degrees = new int[n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken()) - 1;
            int next = Integer.parseInt(st.nextToken()) - 1;
            relations.get(pre).add(next);
            degrees[next]++;
        }

        boolean flag = true;
        int[] buildCount = new int[n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int build = Integer.parseInt(st.nextToken()) - 1;

            if (op == 1) {
                if (0 < degrees[build]) {
                    flag = false;
                    break;
                }
                if (buildCount[build] == 0) {
                    List<Integer> target = relations.get(build);
                    for (int relation : target) {
                        degrees[relation] -= 1;
                    }
                }
                buildCount[build]++;
            } else {
                if (buildCount[build] == 0) {
                    flag = false;
                    break;
                }
                buildCount[build]--;
                if (buildCount[build] == 0) {
                    List<Integer> target = relations.get(build);
                    for (int relation : target) {
                        degrees[relation] += 1;
                    }
                }
            }
        }
        if(flag) {
            System.out.println("King-God-Emperor");
        } else {
            System.out.println("Lier!");
        }

    }
}
