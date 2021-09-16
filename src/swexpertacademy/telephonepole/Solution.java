package swexpertacademy.telephonepole;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


class Solution {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());


        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());

            int[][] wires = new int[n][2];
            for (int i = 0; i < n; i++) {
                int[] wire = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                wires[i] = wire;
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (wires[i][0] < wires[j][0] && wires[i][1] > wires[j][1] || wires[i][0] > wires[j][0] && wires[i][1] < wires[j][1]) {
                        count++;
                    }
                }
            }
            System.out.println("#" + test_case + " " + count);
        }
    }
}