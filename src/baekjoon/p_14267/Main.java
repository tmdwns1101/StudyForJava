package baekjoon.p_14267;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> nodes = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            nodes.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++) {
            int boss = Integer.parseInt(st.nextToken());
            boss = boss == -1 ? 0 : boss;
            nodes.get(boss).add(i);
        }

        int[] answer = new int[n+1];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int me = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            answer[me] += weight;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while(!queue.isEmpty()) {
            int me = queue.poll();
            List<Integer> node = nodes.get(me);
            for(int person: node) {
                answer[person] += answer[me];
                queue.offer(person);
            }
        }
        for(int i=1; i<=n; i++) {
            System.out.print(answer[i]+" ");
        }

    }
}
