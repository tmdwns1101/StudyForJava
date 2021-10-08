package baekjoon.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        List<List<Integer>> nodes = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            nodes.add(new ArrayList<>());
        }

        int[] weights = new int[n+1];
        int[] degrees = new int[n+1];


        for(int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int degree = Integer.parseInt(st.nextToken());
            weights[i] = weight;
            degrees[i] = degree;

            for(int j=0; j<degree; j++) {
                int preTask = Integer.parseInt(st.nextToken());
                nodes.get(preTask).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[n+1];

        for(int i=1; i<=n; i++) {
            result[i] = weights[i];
            if(degrees[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int task = queue.poll();
            List<Integer> node = nodes.get(task);
            for(int next: node) {
                degrees[next] -= 1;
                //현재 작업에 필요 한 시간 = 선행 작업 들이 모두 처리되는데 필요한 시간(선행 작업이 처리되는 시간에서 가장 오래 걸리는 시간 선택) + 현재 작업이 처리되는 시간
                result[next] = Math.max(result[next], result[task]+weights[next]);
                if(degrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        int answer = 0;
        for(int i=0; i<result.length; i++) {
            answer = Math.max(answer, result[i]);
        }
        System.out.println(answer);
    }
}
