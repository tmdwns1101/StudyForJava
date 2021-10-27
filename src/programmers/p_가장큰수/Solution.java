package programmers.p_가장큰수;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
* 1. int -> String 으로 변환
* 2. 정렬 기준
*   1. str1+str2 와 str2+str1 을 비교 한 결과를 내림차순으로 정렬
*   2. ex str1 = "6" str2 = "12" str1+str2 = "612", str2+str1 = "126" 이므로, str1이 str2보다 앞에 정렬되도록 한다.
* 3. 정렬된 배열에 요소들을 합쳐 문자열로 반환
* 4. 단, 0으로 시작되면, 해당 문자열은 모두 0으로 이루어진 문자열이므로, "0"을 반환.
* */
public class Solution {
    public String solution(int[] numbers) {
        String answer = IntStream.of(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1,s2) -> (s2+s1).compareTo(s1+s2))
                .collect(Collectors.joining());
        if(answer.startsWith("0")) return "0";
        return answer;
    }
}
