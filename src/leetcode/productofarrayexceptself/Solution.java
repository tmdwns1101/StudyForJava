package leetcode.productofarrayexceptself;

public class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];

        int[] left = new int[nums.length+1];
        int[] right = new int[nums.length+1];

        left[0] = 1;
        left[1] = nums[0];
        for(int i=1; i<nums.length-1; i++) {
            left[i+1] = left[i] * nums[i];
        }

        right[nums.length] = 1;
        right[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2; i>0; i--) {
             right[i] = right[i+1] * nums[i];
        }

        for(int i=1; i<nums.length+1; i++) {
            answer[i-1] = left[i-1]*right[i];
        }
        return answer;
    }
}
