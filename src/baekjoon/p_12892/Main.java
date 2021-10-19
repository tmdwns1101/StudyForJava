package baekjoon.p_12892;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Present implements Comparable<Present>{
        int price;
        int value;

        Present(int price, int value) {
            this.price = price;
            this.value = value;
        }

        @Override
        public int compareTo(Present present) {
            return Integer.compare(this.price, present.price);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        Present[] presents = new Present[n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            Present present = new Present(price, value);
            presents[i] = present;
        }
        Arrays.sort(presents);

        long answer = 0;
        if(n == 1) {
            answer = presents[0].value;
        } else {
            int left = 0;
            int right = 1;
            long sum = presents[left].value;
            while(right < n) {
                int diff = Math.abs(presents[left].price-presents[right].price);
                if(diff < d) {
                    sum += presents[right].value;
                    right++;
                } else {
                    answer = Math.max(answer, sum);
                    //sum : left 위치에서부터 right 위치 바로 전까지 축적된 만족도 값
                    //따라서, 이미 left에서부터 right 바로 전까지 만족도 양이 계산되어 있기때문에
                    //left의 만족도를 sum에서 빼면, (left+1)...(right-1)의 만족도 양 설정 가능.
                    sum -= presents[left].value;
                    left++;
                    //left와 right가 같다는 것은,  (left+1)...(right-1) 사이에 축적된 양이 없다는 것.
                    //sum = left+1 위치에 만족도 양을 설정.
                    if(left == right) {
                        sum = presents[left].value;
                        right++;
                    }
                }
            }
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }
}
