package programmers.quadcompression;

import java.util.Arrays;

/**
 * 1. 2^n x 2^n 을 4분할
 * 2. n을 1 씩 감소 시킴.
 * 3. n == 0 인 경우가 분할 할 수 있는 가장 작은 값
 * 4. 더이상 분할 할 수 없을 때 해당 행 열의 값을 반환
 * 5. 4분할 해서 얻어 온 값들이 모두 0 이거나 1 이면 해당 값을 리턴
 * 6. 하나라도 다른 값이면, -1 반환
 * 7. -1이 아니라 0 또는 1 이면 해당 0 과 1 의 갯수를 증가
 */
public class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = {0,0};
        int n = (int)(Math.log(arr.length) / Math.log(2));
        int result = divide(0,0, n, arr, answer);
        if(result != -1) {
            answer[result] +=1;
        }
        return answer;
    }

    public int divide(int row, int col, int n, int[][] arr, int[] payload) {
        if(n == 0) {
            return arr[row][col];
        }else {
            int[] quad = new int[4];
            int index = (int)Math.pow(2,n-1);
            quad[0] = divide(row, col, n-1, arr, payload);
            quad[1] = divide(row, col+index, n-1, arr, payload);
            quad[2] = divide(row+index, col, n-1, arr, payload);
            quad[3] = divide(row+index, col+index, n-1, arr, payload);
            if(Arrays.stream(quad).distinct().count() == 1) {
                return quad[0];
            } else {
                for(int elem: quad){
                    if(elem != -1) {
                        payload[elem] += 1;
                    }
                }
                return -1;
            }
        }
    }
}
