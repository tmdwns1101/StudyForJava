package sum3;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(nums);


        for(int i=0; i<nums.length; i++) {


            //중복 Set 방지
            if(i>0 && nums[i] == nums[i-1]) continue;

            int left = i+1;
            int right = nums.length-1;
            while(left < right) {
                int sumValue = nums[i];
                sumValue += nums[left] + nums[right];
                if(sumValue == 0) {



                    List<Integer> sumSet = new ArrayList<>();
                    sumSet.add(nums[i]);
                    sumSet.add(nums[left]);
                    sumSet.add(nums[right]);
                    answer.add(sumSet);
                    while (left < right && nums[left] == nums[left+1]) left += 1;
                    while (right > left && nums[right] == nums[right-1]) right -= 1;
                    left += 1;
                    right -= 1;
                } else if(sumValue < 0) {
                    left += 1;
                } else {
                    right -= 1;
                }
            }
        }

        return answer;
    }
}
