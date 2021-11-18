package leetcode.p_621;

import java.util.*;

public class Solution {

    private class Task implements Comparable<Task> {
        char type;
        int count;

        public Task(char type, int count) {
            this.type = type;
            this.count = count;
        }

        @Override
        public int compareTo(Task o) {
            return Integer.compare(o.count, this.count);
        }
    }

    public int leastInterval(char[] tasks, int n) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Task> queue = new PriorityQueue<>();
        Queue<Character> coolDownQueue = new LinkedList<>();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.offer(new Task(entry.getKey(), entry.getValue()));
        }

        while (!queue.isEmpty()) {
            boolean flag = true;
            List<Task> list = new ArrayList<>();
            while (flag) {
                if (queue.isEmpty()) {
                    int idleTime = (n+1)  - coolDownQueue.size();
                    answer += idleTime;
                    coolDownQueue.poll();
                    while(idleTime > 0) {
                        coolDownQueue.offer('i');
                        idleTime--;
                    }
                    flag = false;
                } else {
                    Task task = queue.poll();
                    if (!coolDownQueue.contains(task.type)) {
                        answer++;
                        coolDownQueue.offer(task.type);
                        task.count--;
                        if(task.count > 0) {
                            list.add(task);
                        }
                        if(coolDownQueue.size() > n) {
                            coolDownQueue.poll();
                        }
                        flag = false;
                    } else {
                        list.add(task);
                    }
                }
                if(!flag) queue.addAll(list);
            }
        }

        return answer;
    }


}
