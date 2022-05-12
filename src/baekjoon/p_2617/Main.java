package baekjoon.p_2617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 구슬 찾기 - 2617
 * */
public class Main {

    private static final int WIN = 1;
    private static final int LOSE = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] score = new int[n][n];

        for(int i=0; i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int winner = Integer.parseInt(st.nextToken()) - 1;
            int loser = Integer.parseInt(st.nextToken()) - 1;
            score[winner][loser] = WIN;
            score[loser][winner] = LOSE;
        }

        int middle = (n+1)/2;

        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(score[i][j] == 0) {
                        if(score[i][k] == WIN && score[k][j] == WIN) {
                            score[i][j] = WIN;
                        }
                        if(score[i][k] == LOSE && score[k][j] == LOSE) {
                            score[i][j] = LOSE;
                        }
                    }
                }
            }
        }

        int answer = 0;
        for(int i=0; i<n; i++) {
            int winCount  = 0;
            int loseCount = 0;
            for(int j=0; j<n; j++) {
                if(score[i][j] == WIN) winCount++;
                if(score[i][j] == LOSE) loseCount++;
            }
            if(winCount >= middle || loseCount >= middle) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
