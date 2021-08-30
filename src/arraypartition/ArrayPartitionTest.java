package arraypartition;

public class ArrayPartitionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {6,2,6,5,1,2};
        int result = solution.arrayPairSum(nums);
        System.out.println("result = " + result);
    }
}
