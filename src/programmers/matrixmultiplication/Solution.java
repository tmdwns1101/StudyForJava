package programmers.matrixmultiplication;

public class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];


        //arr1 x arr2 = arr1의 행의 길이 x arr2의 열의 길이 를 갖는 새로운 행렬
        //arr1 행의 개수 증가
        for(int i=0; i<arr1.length; i++) {
            //arr2의 열의 개수 증가
            for(int j=0; j<arr2[0].length; j++) {
                int sum = 0;
                //행과 열 고정 후
                //arr1의 행값과 arr2의 열값 곱셈 후 값을 더함.
                for(int k=0; k < arr1[0].length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                //더한 값은 i x j 의 값
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}
