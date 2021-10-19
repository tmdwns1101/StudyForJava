package baekjoon.p_2467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Comparator.comparingInt(Math::abs));
        int pivot = Integer.MAX_VALUE;

        int left = 0;
        int right = 1;

        int[] answer = new int[2];

        //arr의 요소들은 절대값 기준으로 정렬 되어있다.
        //pivot : 0에 가까운 최소 값
        while(left < arr.length && right < arr.length) {

            int absSum = Math.abs(arr[left]+arr[right]);

            //left 와 right 합의 절대값이 pivot보다 크다면, right+1에 값과의 합의 절대값은 언제나 privot 보다 크다(배열의 요소가 절대값 기준으로 정렬되어 있으므로)
            if(absSum >= pivot) {
                left++;
                if(left == right) right++;
            } else {
                //left 값과 right 값이 기존 pivot값보다 작다면, pivot 값을 갱신
                pivot = absSum;
                answer[0] = arr[left];
                answer[1] = arr[right];
                right++;
            }
        }
        Arrays.sort(answer);
        for(int i=0; i<answer.length; i++) {
            System.out.print(answer[i]);
            if(i != 1) {
                System.out.print(" ");
            }
        }
    }

}
