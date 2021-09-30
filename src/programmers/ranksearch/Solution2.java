package programmers.ranksearch;

import java.util.*;

public class Solution2 {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        Map<String, List<Integer>> map = new HashMap<>();
        for(String item: info) {

            String[] parse = item.split(" ");
            int score = Integer.parseInt(parse[4]);
            for(int i=0; i < (1<<4); i++){
                StringBuilder key = new StringBuilder();
                for(int j=0; j<4; j++) {
                    if((i & (1<<j)) > 0) key.append(parse[j]);
                }
                map.computeIfAbsent(key.toString(), s -> new ArrayList<>()).add(score);
            }
        }

        for(Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            entry.getValue().sort(Comparator.naturalOrder());
        }

        for(int i=0; i<query.length; i++) {
            String[] split = query[i].replaceAll("-","").split(" and | ");
            String key = String.join("",split[0],split[1],split[2],split[3]);
            int score = Integer.parseInt(split[4]);
            List<Integer> scores = map.getOrDefault(key,new ArrayList<>());

            int left = 0;
            int right = scores.size();
            while(left < right) {
                int mid = (left + right) / 2;
                if(scores.get(mid) < score) left = mid + 1;
                else right = mid;
            }
            answer[i] = scores.size() - left;
        }

        return answer;
    }
}
