package menurenewal;

import java.util.*;

public class Solution {
    private  Map<Integer, Map<String, Integer>> courseMap = new HashMap<>();

    public  String[] solution(String[] orders, int[] course) {

        String[] answer = {};

        for(int c: course) {
            courseMap.put(c, new HashMap<>());
        }

        for(String order: orders) {
            char[] orderChars = order.toCharArray();
            Arrays.sort(orderChars);
            permuatation(orderChars,"",0);
        }

        List<String> result = new ArrayList<>();
        for(Map.Entry<Integer, Map<String,Integer>> entry: courseMap.entrySet()) {
            Map<String, Integer> map = entry.getValue();
            Stack<String> stack = new Stack<>();
            int maxCount = 2;
            for (String s : map.keySet()) {
                if(maxCount < map.get(s)) {
                    while(!stack.isEmpty()) {
                        stack.pop();
                    }
                    stack.add(s);
                    maxCount = map.get(s);
                } else if(maxCount == map.get(s)) {
                    stack.add(s);
                }
            }
            while(!stack.isEmpty()) {
                result.add(stack.pop());
            }
        }

        result.sort(String::compareTo);

        return result.toArray(answer);
    }

    public void permuatation(char[] order, String course, int startIdx) {
        if(courseMap.containsKey(course.length())) {
            int len = course.length();
            courseMap.get(len).put(course, courseMap.get(len).getOrDefault(course, 0) + 1);
        }
        for(int i=startIdx; i<order.length;i++) {
            permuatation(order,course+order[i],i+1);
        }

    }
}
