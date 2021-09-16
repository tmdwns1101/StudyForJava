package leetcode.mostcommonword;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(mostCommonWord("Bob, ball,     hit.           ", new String[] {"hit"}));
    }
    public static String mostCommonWord(String paragraph, String[] banned) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();

        String[] strings = paragraph.replaceAll("[^A-Za-z]", " ").toLowerCase().split(" ");
        String[] test = "baaabbbaaccaa".split("a");

        List<String> words = Arrays.stream(paragraph.replaceAll("\\W", " ").toLowerCase().split(" "))
                .collect(Collectors.toList());

        words.forEach(word -> {
            if(!Arrays.asList(banned).contains(word) && !word.equals("")) {
                if(map.containsKey(word)) {
                   int count = map.get(word);
                   map.put(word, count+1);
                } else {
                    map.put(word,1);
                }
            }
        });

      Set<String> stringSet = map.keySet();

      int max = 0;

      for (String key : stringSet) {
        if(max < map.get(key))  {
            max = map.get(key);
            answer = key;
        }
      }
        return answer;
    }
}
