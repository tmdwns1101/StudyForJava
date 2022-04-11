package programmers.p_다리를_지나는_트럭;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    private class Status {
        int weight;
        int time;

        public Status(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Deque<Status> deque = new ArrayDeque<>();

        int tempWeight = 0;
        int time = 0;
        for (int truckWeight : truck_weights) {
            time++;
            if (!deque.isEmpty()) {
                /**
                 * 1. 이전 time의 이미 다리 길이 만큼 트럭이 들어와 있는 경우로,
                 * 2. time == 가장 앞에 있는 트럭이 다리에 들어온 시간 + bridge_length 은 제일 앞에 있는 트럭이 다리를 건너게 된다.
                 * */
                if (time == deque.peekFirst().time + bridge_length) {
                    Status front = deque.pollFirst();
                    tempWeight -= front.weight;
                }

                /**
                 * 1. deque가 비어있지 않고, 현재 다리에 있는 트럭의 총 무게 와 새로 들어올려는 트럭 무게가 견딜 수 있는 무게보다 클 경우
                 * 2. deque를 들어온 순서대로 빼주면서, time 값 갱신
                 * 3. time 값은 결국 (맨 마지막으로 나가는 트럭의 다리 진입 시간 + 다리의 총 길이 = 해당 트럭이 들어오기 위해 처리된 시간)
                 * */
                while (!deque.isEmpty() && tempWeight + truckWeight > weight) {
                    Status front = deque.pollFirst();
                    time = front.time + bridge_length;
                    tempWeight -= front.weight;
                }
            }
            deque.addLast(new Status(truckWeight, time));
            tempWeight += truckWeight;
        }

        /**
         * 1. 마지막으로 다리에 진입한 트럭의 시간 + 다리 길이는
         * 2. 결국 모든 트럭이 다리를 진입하는 시간이 된다.
         * */
        return deque.getLast().time + bridge_length;
    }
}
