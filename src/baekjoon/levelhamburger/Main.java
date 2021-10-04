package baekjoon.levelhamburger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] hb = new long[51];
    static long[] p = new long[51];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());

        hb[0] = 1;
        p[0] = 1;

        for(int i=1; i<=50; i++) {
            hb[i] = 1+ hb[i-1] + 1 + hb[i-1] + 1;
            p[i] = p[i-1] + 1 + p[i-1];
        }
        long answer = dfs(n,x);
        System.out.println(answer);

    }

    static long dfs(int n,long x) {
        //level-0 일때는 패티만 1장있는 경우 이므로 x==1 일때 패티 한장 먹을 수 있으므로,
        //1반환
        if(n == 0) {
            if(x == 0) return 0;
            else if(x == 1) return 1;
        }

        //x==1 이면 번이므로, 패티를 먹을 수 없으므로 0 반환
        if(x == 1) return 0;
        //번-hb[n-1]-패티 사이 까지만 먹었다면, hb[n-1] 에서 x-1 만큼 먹었다는 것이다.(x-1인 이유는, n의 첫번째는 무조건 번이므로)
        else if(x < 1 + hb[n-1] + 1) return dfs(n-1, x-1);
        //hb[n]의 중간(번-hb[n-1]-패티)까지 먹었으면, 전 레벨의 햄버거는 모두 먹었고, 추가된 패티 한장 먹었으므로
        else if(x == 1 + hb[n-1] + 1) return 1 + p[n-1];
        //새로 추가된 패티 이후로 hb[n-1]의 몇장을 더 먹은 것이므로, 
        else if(x <= 1 + hb[n-1] + 1 + hb[n-1]) return 1 + p[n-1] + dfs(n-1, x-1-hb[n-1]-1);
        //해당 햄버거를 모든 재료를 다 먹은 경우
        else return 2 * p[n-1] + 1;
    }
}
