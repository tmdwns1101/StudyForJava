package voweldictionary;

public class Solution {

    static int count = 0;
    public int solution(String word) {
        String[] vowels = {"A", "E", "I", "O", "U"};
        int answer = recursive("",word,vowels);
        return answer;
    }

    private int recursive(String word, String target,  String[] vowels) {

        //기저 조건
        //지금까지 만들어진 문자열과 타켓 문자열과 같을 경우 count 반환
        if(word.equals(target)) return count;

        //문자열은 길이 5가 넘으면 안되므로
        else if(word.length() != 5){
            int answer = 0;
            for (String vowel : vowels) {
                count += 1;
                answer = Math.max(answer, recursive(word.concat(vowel), target, vowels));
            }
            return answer;
        }

        //target 문자열을 만들 수 없는 경우 -1 반환
        return -1;
    }
}
