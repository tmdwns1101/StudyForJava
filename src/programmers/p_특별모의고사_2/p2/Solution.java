package programmers.p_특별모의고사_2.p2;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] s1 = {"A", "E", "B", "D", "B", "H", "F", "H", "C"};
        String[] s2 = {"G", "C", "G", "F", "J", "E", "B", "F", "B"};
        String k = "B";
        String[] answer = solution(s1, s2, k);
        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));
    }


    static class Node implements Comparable<Node> {
        String subject;
        int depth;
        Node(String subject, int depth) {
            this.subject = subject;
            this.depth = depth;
        }

        @Override
        public int compareTo(Node o) {
            if(this.depth != o.depth) {
                return Integer.compare(this.depth, o.depth);
            }
            return this.subject.compareTo(o.subject);
        }
    }

    public static String[] solution(String[] s1, String[] s2, String k) {
        String[] answer;

        Map<String, List<String>> needSubjects = new HashMap<>();
        Map<String, List<String>> connections = new HashMap<>();
        Map<String, Integer> degrees = new HashMap<>();
        degrees.put(k, 0);
        for (int i = 0; i < s1.length; i++) {
            String preSub = s1[i];
            String sub = s2[i];

            List<String> connection = connections.getOrDefault(sub, new ArrayList<>());
            connection.add(preSub);
            connections.put(sub, connection);
            degrees.put(preSub, degrees.getOrDefault(preSub, 0) + 1);

//            List<String> list = needSubjects.getOrDefault(sub, new ArrayList<>());
//            list.add(preSub);
//            needSubjects.put(sub, list);
        }
        degrees.put(k, 0);
        //List<String> takeSubjects = calcTakeSubjects(needSubjects, k);

        //위상정렬
        //List<String> result = topologicalSort(takeSubjects, connections, degrees, k);
        List<String> result = topologicalSort(connections, degrees, k);
        answer = result.toArray(new String[result.size()]);

        return answer;
    }

    //과목 k와 연관된 과목 리스트
    public static List<String> calcTakeSubjects(Map<String, List<String>> map, String k) {
        List<String> takeSubjects = new ArrayList<>();
        takeSubjects.add(k);
        Queue<String> queue = new LinkedList<>();
        if (!map.containsKey(k)) {
            return takeSubjects;
        }
        for (String item : map.get(k)) {
            queue.offer(item);
        }
        while (!queue.isEmpty()) {
            String preSubject = queue.poll();
            if (!takeSubjects.contains(preSubject)) takeSubjects.add(preSubject);

            if (map.containsKey(preSubject)) {
                for (String item : map.get(preSubject)) {
                    queue.offer(item);
                }
            }
        }
        return takeSubjects;

    }

    //위상정렬
    public static List<String> topologicalSort(Map<String, List<String>> connections, Map<String, Integer> degrees, String k) {
        List<String> result = new ArrayList<>();
        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.offer(new Node(k, 0));
        while (!queue.isEmpty()) {
            Node front = queue.poll();
            result.add(front.subject);
            if (connections.containsKey(front.subject)) {
                for (String sub : connections.get(front.subject)) {
                    int nDegree = degrees.get(sub) - 1;
                    degrees.put(sub, nDegree);
                    if (nDegree == 0) {
                        queue.offer(new Node(sub, front.depth+1));
                    }
                }
            }

        }
        return result;
    }
}
