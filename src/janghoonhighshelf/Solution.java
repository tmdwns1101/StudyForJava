package janghoonhighshelf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case<=T; test_case++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int[] clerks = new int[n];
            for(int i=0; i<n; i++) {
                clerks[i] = Integer.parseInt(st2.nextToken());
            }

            int answer = dfs(b,n,clerks,0,0) - b;
            System.out.println("#"+test_case+" "+answer);
        }
    }

    public static int dfs(int b, int n, int[] clerks, int startIdx, int topHeight) {
        if(topHeight >= b) return topHeight;
        else {
            int result = Integer.MAX_VALUE;
            for(int i=startIdx; i<n; i++) {
                 result = Math.min(result, dfs(b, n, clerks, i+1, topHeight+clerks[i]));
            }
            return result;
        }
    }
}
