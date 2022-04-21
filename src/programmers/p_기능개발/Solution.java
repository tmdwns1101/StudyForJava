package programmers.p_기능개발;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        int n = progresses.length;
        int[] rests = new int[n];


        for (int i = 0; i < n; i++) {
            rests[i] = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(rests[0]);

        List<Integer> deploys = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            int rest = rests[i];
            if (!queue.isEmpty()) {
                int front = queue.peek();
                if (rest <= front) {
                    queue.offer(rest);
                } else {
                    int count = 0;
                    while (!queue.isEmpty()) {
                        queue.poll();
                        count++;
                    }
                    queue.offer(rest);
                    deploys.add(count);
                }
            } else {
                queue.offer(rest);
            }
        }

        deploys.add(queue.size());
        return deploys.stream().mapToInt(Integer::intValue).toArray();
    }
}
