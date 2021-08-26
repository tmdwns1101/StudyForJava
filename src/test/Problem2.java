package test;

import java.util.*;

public class Problem2 {
    public List<String> solution(String[] grades) {
        List<String> answer =  new ArrayList<>();


        String[] ranks = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D+", "D0", "D-", "F"};
        Map<String, Integer> gradeMap = new HashMap<>();
        for(int i =0; i<ranks.length; i++) {
            String rank = ranks[i];
            gradeMap.put(rank, i);
        }

        class Data {
            String rank;
            int index;
            public Data(String rank, int index) {
                this.index = index;
                this.rank = rank;
            }

        }
        //subjet, rank
        Map<String, Data> result = new HashMap<>();


        for(int i=0; i<grades.length; i++) {
            String grade = grades[i];
            String subject = grade.split(" ")[0];
            String rank = grade.split(" ")[1];
            if(result.containsKey(subject)) {
                if( gradeMap.get(result.get(subject).rank) > gradeMap.get(rank)) {
                    result.put(subject, new Data(rank, i));
                }
            } else {
                result.put(subject, new Data(rank, i));
            }
        }

        List<Map.Entry<String, Data>> entries = new LinkedList<>(result.entrySet());
        entries.sort((o1, o2) ->  {
            int rank1 =  gradeMap.get(o1.getValue().rank);
            int rank2 =  gradeMap.get(o2.getValue().rank);
            int index1 = o1.getValue().index;
            int index2 = o2.getValue().index;
            if(rank1 < rank2) {
                return -1;
            } else if (rank1 > rank2) {
                return 1;
            } else {
                return Integer.compare(index1, index2);
            }
        });

        LinkedHashMap<String, Data> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, Data> entry : entries) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        for (String s : linkedHashMap.keySet()) {
            String value = s + " " + linkedHashMap.get(s).rank;
            answer.add(value);
        }

        return answer;
    }
}
