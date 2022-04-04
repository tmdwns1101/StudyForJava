package programmers.p_크레인_인형뽑기_게임;

import java.util.Stack;

public class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        int n = board.length;

        //각 열에 인형이 있는 행 위치
        int[] idx = new int[n];


        for(int j=0; j<n; j++) { // 열 고정
            for (int i=0; i<n; i++) {
                if(board[i][j] != 0) { // board[i][j] 에 인형이 있을 경우 해당 최초 위치 기록
                   idx[j] = i;
                   break;
                }
            }
        }

        Stack<Integer> basket = new Stack<>();

        /**
         * 1. move가 있는 열에 인형이 있는 행 idx[col] 가져오기
         * 2. board[row][col] 에 인형이 있을 경우
         *  2-1. 바구니가 비어있으면, 아무 조건없이 push
         *  2-2. 바구니가 비어있지 않을 경우, 가장 위에 있는 인형과 비교하여 같으면 pop , answer + 2 / 같지 않으면, push
         * 3. 크레인으로 인형을 뽑았으니 board[row][col] = 0
         * 4. 해당 열 인형 위치(행) + 1 (인형은 차곡 차곡 쌓였으므로 인형이 있던 위치 + 1에도 인형이 있음) 단, n 이상일 경우 더 이상 증가 하지 않는다.
         * */
        for(int move: moves) {

            int col = move - 1;
            int row = idx[col];
            int doll = board[row][col];
            if(doll != 0){
                if(!basket.empty()) {
                    int top = basket.peek();
                    if(top == doll) {
                        basket.pop();
                        answer += 2;
                    } else {
                        basket.push(doll);
                    }
                } else {
                    basket.push(doll);
                }
                board[row][col] = 0;
                idx[col] = idx[col] + 1 >= n ? n - 1 : idx[col] + 1;

            }
        }

        return answer;
    }
}
