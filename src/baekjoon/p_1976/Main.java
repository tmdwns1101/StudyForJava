package baekjoon.p_1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] parent = new int[n+1];
        for(int i=0; i<=n; i++) parent[i] = i;

        for(int i=1; i<=n; i++) {
            int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=1; j<=n; j++) {
                if(info[j-1] == 1) {
                    union(parent, i, j);
                }
            }
        }

        int[] travel = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int p = find(parent,travel[0]);
        boolean isOk = true;
        for(int i=1; i<travel.length; i++) {
            if(p != find(parent,travel[i])) {
                isOk = false;
                break;
            }
        }
        if(isOk) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
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
