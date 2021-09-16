package leetcode.twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        int[] result = twoSum(nums,target);
        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] twoSum(int[] nums, int target) {

        int[] answer = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(target-nums[i])) {
                answer[0] = i;
                answer[1] = map.get(target-nums[i]);
                return  answer;
            }
            map.put(nums[i],i);

        }
        return answer;
    }
}
