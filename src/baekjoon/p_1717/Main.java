package baekjoon.p_1717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] parent = new int[n+1];
        for(int i=0; i<=n; i++) parent[i] = i;

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int operation = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            if(operation == 0) {
                union(parent, num1, num2);
            } else {
                int p1 = find(parent, num1);
                int p2 = find(parent, num2);
                if(p1 == p2) {
                    System.out.println("YES");
                } else  {
                    System.out.println("NO");
                }
            }
        }
    }

    private static int find(int[] parent, int me) {
        if(parent[me] == me) return me;
        else return parent[me] = find(parent, parent[me]);
    }

    private static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
}
