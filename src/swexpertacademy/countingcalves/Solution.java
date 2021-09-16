package swexpertacademy.countingcalves;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int[] nAndq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = nAndq[0];
            int q = nAndq[1];

            int[] calves = new int[n];
            //1~N번 까지 송아지 품종 입력
            for (int i = 0; i < n; i++) {
                calves[i] = Integer.parseInt(br.readLine());
            }

            int[][] dp = new int[n][3];
            int[] breedCount = new int[3];

            //i번째 까지 각 송아지 품종 개수 저장
            for (int i = 0; i < calves.length; i++) {
                breedCount[calves[i] - 1]++;
                dp[i] = Arrays.copyOf(breedCount, 3);
            }


            int[][] questions = new int[q][2];
            //Q 개수 대로 L과R 입력
            for (int i = 0; i < q; i++) {
                int[] lr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                questions[i] = lr;
            }

            System.out.println("#" + test_case);

            //dp[right] : right 번호까지 품종 1,2,3의 개수
            //left ~ right 까지의 품종 별 개수를 알기 위해서는
            //right - (left-1) 품종 별 개수를 구함면 됨.
            //left 가 1일경우, 1번 부터 right 까지 이므로 결국 dp[right]
            for (int[] question : questions) {
                int left = question[0]-1;
                int right = question[1]-1;

                int[] answer = new int[3];
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 3; j++) {
                    answer[j] = left > 0 ? dp[right][j] - dp[left - 1][j] : dp[right][j];
                    sb.append(answer[j]);
                    if (j != 2) {
                        sb.append(" ");
                    }
                }
                System.out.println(sb.toString());
            }

        }
    }
}
