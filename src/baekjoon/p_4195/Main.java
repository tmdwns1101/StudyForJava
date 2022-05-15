package baekjoon.p_4195;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * 친구 네트워크 - 4195
 * */
public class Main {

    static class Parent {
        String parent;
        int count;

        public Parent(String parent, int count) {
            this.parent = parent;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=0; t<testCase; t++) {
            int n = Integer.parseInt(br.readLine());

            Map<String, Parent> map = new HashMap<>();
            StringTokenizer st;

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                String friend1 = st.nextToken();
                String friend2 = st.nextToken();

                if(!map.containsKey(friend1)) {
                    map.put(friend1, new Parent(friend1, 1));
                }

                if(!map.containsKey(friend2)) {
                    map.put(friend2, new Parent(friend2, 1));
                }

                union(map, friend1, friend2,sb);
            }
        }
        System.out.println(sb);
    }

    private static String find(Map<String, Parent> parentMap, String me) {
        if(parentMap.get(me).parent.equals(me)) return me;
        else return parentMap.get(me).parent = find(parentMap, parentMap.get(me).parent);
    }

    private static void union(Map<String, Parent> parentMap, String a, String b, StringBuilder sb) {
        a = find(parentMap, a);
        b = find(parentMap, b);
        Parent p1 = parentMap.get(a);
        Parent p2 = parentMap.get(b);

        //부모가 다를 경우에만 갱신
        //b - c, a - b (이 때 이미 a - b - c 집합 관계를 알게됨), a - c (이미 집합 관계이므로 c는 find 과정에서 부모가 a로 바뀜(원래 b였음), 집합 개수는 갱신 안함)
        if(!a.equals(b)) {
            p1.count += p2.count;
            p2.parent = p1.parent;
        }
        sb.append(p1.count).append("\n");

    }
}
