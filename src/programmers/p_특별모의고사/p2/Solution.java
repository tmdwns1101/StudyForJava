package programmers.p_특별모의고사.p2;

import java.util.*;

public class Solution {
    private class People implements Comparable<People> {
        String name;
        int arriveTime;
        boolean isBooked;

        People(String name, int arriveTime, boolean isBooked) {
            this.name = name;
            this.arriveTime = arriveTime;
            this.isBooked = isBooked;
        }

        @Override
        public int compareTo(People people) {
            if (this.isBooked != people.isBooked) {
                if(this.isBooked) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return Integer.compare(this.arriveTime, people.arriveTime);
        }

    }

    public String[] solution(String[][] booked, String[][] unbooked) {
        String[] answer = new String[booked.length + unbooked.length];

        List<People> people = new ArrayList<>();
        for (String[] p : booked) {
            String[] arriveTime = p[0].split(":");
            String name = p[1];
            people.add(new People(name, Integer.parseInt(arriveTime[0]) * 60 + Integer.parseInt(arriveTime[1]), true));
        }
        for (String[] p : unbooked) {
            String[] arriveTime = p[0].split(":");
            String name = p[1];
            people.add(new People(name, Integer.parseInt(arriveTime[0]) * 60 + Integer.parseInt(arriveTime[1]), false));
        }

        people.sort(Comparator.comparingInt(p -> p.arriveTime));


        PriorityQueue<People> queue = new PriorityQueue<>();
        queue.offer(people.get(0));
        int i = 1;
        int j = 0;
        int currentTime = people.get(0).arriveTime;
        while (!queue.isEmpty()) {
            People p = queue.poll();
            answer[j] = p.name;
            j++;
            for (int k = currentTime; k <= currentTime + 10; k++) {
                if (i < people.size() && people.get(i).arriveTime == k) {
                    queue.offer(people.get(i));
                    i++;
                }
            }
            if (queue.isEmpty() && i < people.size()) {
                currentTime = people.get(i).arriveTime;
                queue.offer(people.get(i));
                i++;
            } else {
                currentTime += 10;
            }

        }
        return answer;
    }
}
