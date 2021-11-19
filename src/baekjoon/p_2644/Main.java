package baekjoon.p_2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = -1;

        int me = Integer.parseInt(st.nextToken());
        int you = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> myChildren = new HashMap<>();
        int[] myParent = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            List<Integer> children = myChildren.getOrDefault(parent, new ArrayList<>());
            children.add(child);
            myChildren.put(parent, children);
            myParent[child] = parent;
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[n + 1];
        queue.offer(new int[]{me, 0});
        isVisited[me] = true;
        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            int person = front[0];
            int distance = front[1];
            if (person == you) {
                answer = distance;
                break;
            }

            int parent = myParent[person];
            if (parent != 0 && !isVisited[parent]) {    //자신의 부모를 탐색 노드로 추가, 단 이미 탐색한 노드면 큐에 삽입하지 않음.
                queue.offer(new int[]{parent, distance + 1});
            }

            List<Integer> children = myChildren.getOrDefault(person, new ArrayList<>());

            for (int child : children) {   //자신의 자식을 탐색 노드로 추가, 단 이미 탐색
                if (!isVisited[child]) {
                    queue.offer(new int[]{child, distance + 1});
                    isVisited[child] = true;
                }
            }


        }
        System.out.println(answer);

    }
}
