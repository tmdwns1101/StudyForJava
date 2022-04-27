package baekjoon.p_2422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 2422
 * 한윤정이 이탈리아에 가서 아이스크림을 사먹는데
 * */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] check = new boolean[n][n];
        for(int i=0; i<n; i++) {
            check[i][i] = true;
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int ice1 = Integer.parseInt(st.nextToken()) - 1;
            int ice2 = Integer.parseInt(st.nextToken()) - 1;
            check[ice1][ice2] = true;
            check[ice2][ice1] = true;
        }

        int answer = 0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(!check[i][j]){
                    for(int k=j+1;k<n; k++) {
                        if(!check[i][k] && !check[j][k]) answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }


}
