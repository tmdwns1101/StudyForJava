package monsterhunt;

import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());


        for (int test_case = 1; test_case <= T; test_case++) {

            long[] test = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            long d = test[0];
            long l = test[1];
            long n = test[2];

            long result = (d * n) + ((n - 1) * n * l * d) / 200;

            System.out.println("#" + test_case + " " + result);

        }
    }
}