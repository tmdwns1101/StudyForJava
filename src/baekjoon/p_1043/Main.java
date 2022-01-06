package baekjoon.p_1043;

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

        boolean[] visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            int p = Integer.parseInt(st.nextToken())-1;
            queue.offer(p);
            visited[p] = true;
        }

        List<List<Integer>> parties = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> party = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            for (int j = 0; j < l; j++) {
                int p = Integer.parseInt(st.nextToken())-1;
                party.add(p);
            }
            parties.add(party);
        }


        List<List<Integer>> nodes = new ArrayList<>();
        for(int i=0; i<n; i++) {
            nodes.add(new ArrayList<>());
        }

        for(List<Integer> party: parties) {
            for(int i=0; i<party.size()-1; i++) {
                for(int j=i+1; j<party.size();j++) {
                    int personA = party.get(i);
                    int personB = party.get(j);
                    nodes.get(personA).add(personB);
                    nodes.get(personB).add(personA);
                }
            }
        }

        while(!queue.isEmpty()) {
            int front = queue.poll();
            List<Integer> node = nodes.get(front);
            for(int elem: node) {
                if(!visited[elem]) {
                    visited[elem] = true;
                    queue.offer(elem);
                }
            }
        }

        int answer = 0;

        for(List<Integer> party: parties) {
            if(party.stream().noneMatch(elem -> visited[elem])) {
                answer++;
            }
        }



        System.out.println(answer);

    }
}
