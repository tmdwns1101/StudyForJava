package productofarrayexceptself;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1,1,0,-3,3};
        int[] result = solution.productExceptSelf(nums);
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
    }
}
