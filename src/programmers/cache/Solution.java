package programmers.cache;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();


        String[] convertToLowercaseCities =  Arrays.stream(cities).map(String::toLowerCase).toArray(String[]::new);
        if(cacheSize == 0) {
            answer = convertToLowercaseCities.length * 5;
        } else {
            for (String city : convertToLowercaseCities) {

                //큐에 해당 도시명이 있는 경우
                //해당 도시명을 큐에 가장 뒤쪽으로 옮김.
                if (queue.contains(city)) {
                    queue.remove(city);
                    queue.offer(city);
                    answer += 1;
                } else {
                    if (queue.size() == cacheSize) {
                        queue.poll();
                    }
                    queue.offer(city);
                    answer += 5;
                }
            }
        }
        return answer;
    }
}
