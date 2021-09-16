package leetcode.groupanagrams;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] problems = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(solution(problems));
    }
    public static List<List<String>> solution(String[] strs) {

//        List<List<String>> answer = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
//            String sortedStr = Arrays.stream(str.split("")).sorted().collect(Collectors.joining());
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            if(map.containsKey(sortedStr)) {
                map.get(sortedStr).add(str);
            } else {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(str);
                map.put(sortedStr,newGroup);
            }
        }

////        map.keySet().forEach(key -> answer.add(map.get(key)));
//
//        return answer;
        return new ArrayList<>(map.values());
    }
}
