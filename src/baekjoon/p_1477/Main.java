package baekjoon.p_1477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int answer = l;

        int[] locations = new int[n+2];

        //시작점 = 0, 고속 도로 끝나는 점 = l
        locations[0] = 0;
        locations[1] = l;
        if(n > 0) {
            st = new StringTokenizer(br.readLine());

            for (int i = 2; i < n + 2; i++) {
                locations[i] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(locations);



        //최소 거리 값 = 1, 왜냐하면 휴게소는 같은 위치에 있지 않으므로 최소 1 이상 휴게소 사이에 거리가 존재
        int left = 1;
        int right = l;
        while(left <= right) {
            int mid = (left+right) / 2;
            int count = 0;
            for(int i=1; i<locations.length; i++) {
               count += (locations[i] - locations[i-1] - 1) / mid;

            }
            if(count <= m) {
                right = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
