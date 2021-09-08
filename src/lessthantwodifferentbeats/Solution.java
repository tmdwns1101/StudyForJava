package lessthantwodifferentbeats;
/*
* 프로그래머스 2개 이하로 다른 비트
* */
public class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int i=0; i<numbers.length; i++) {
            long number = numbers[i];
            //해당 정수를 binary 문자열로 바꿈
            //단, 7, 15 은 111, 1111 이므로 '0'이 하나도 안 존재
            //맨 앞에 '0'을 추가하여 최초이자 마지막 '0' 으로 찾음.
            String binary = "0" + Long.toBinaryString(number);
            StringBuilder result = new StringBuilder(binary);
            int lastZeroIndex = result.lastIndexOf("0");
            result.setCharAt(lastZeroIndex, '1');
            if(number % 2 != 0) {
                //홀수인 경우
                //마지막으로 등장한 '0' 바로 뒤에 등장하는 최초에 '1'을 '0'으로 바꿔주면
                //최소 값 구할 수 있음.
                result.setCharAt(result.indexOf("1", lastZeroIndex+1), '0');
            }
            answer[i] = Long.parseLong(result.toString(),2);
        }

        return answer;
    }
}
