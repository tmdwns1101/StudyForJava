package lettercombinationsofaphonenumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* leetCode 17 - Letter Combinations of a Phone Number
* */
public class Solution {

    private Map<Character,String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        if(digits.length() > 0) {
            dfs(digits, 0, "", answer);
        }

        return answer;
    }

    private void dfs(String digits, int index, String letter, List<String> answer) {
        //base 조건
        //index 값이 digits 의 길이가 같다는 것은 주어진 digits을 통해 하나의 조합을 완성 시켰음.
        //완성된 letter 조합 추가
        if(index == digits.length()) answer.add(letter);
        else {
            String currentStr = map.get(digits.charAt(index));

            //해당 digits이 갖고 있는 문자 loop
            //기존 미완성된 letter와 합치면서 깊이를 증가(index 값 증가)시키면서 DFS 진행
            for(int i=0; i<currentStr.length(); i++) {
                dfs(digits, index+1,letter+currentStr.charAt(i), answer);
            }
        }
    }
}
