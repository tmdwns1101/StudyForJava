package baekjoon.p_15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    private  static int n;
    private  static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());

         boolean[] isVisited = new boolean[n];
         int[] arr = new int[m];

         dfs(arr, 0, isVisited);

    }

    private static void dfs(int[] arr, int size, boolean[] isVisited) {
        if(size == m) {
            String str = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(str);
        } else {
            for(int i=0; i<n; i++) {
                if(!isVisited[i]) {
                    isVisited[i] = true;
                    arr[size] = i+1;
                    dfs(arr,size+1,isVisited);
                    isVisited[i] = false;
                }
            }
        }
    }
}
