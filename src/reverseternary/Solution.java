package reverseternary;

/*
* 프로그래머스 3진법 뒤집기
* */
public class Solution {
    public int solution(int n) {
        int m = n;
        String ternary = "";

        //10진법을 3진법 수로 변환
        while(true) {
            if(m < 3) {
                ternary = String.valueOf(m).concat(ternary);
                break;
            }
            ternary = String.valueOf(m % 3).concat(ternary);
            m = m / 3;

        }
        StringBuilder stringBuilder = new StringBuilder(ternary);

        return Integer.parseInt(stringBuilder.reverse().toString(),3);
    }
}
