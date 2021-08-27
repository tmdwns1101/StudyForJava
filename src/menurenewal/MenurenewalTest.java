package menurenewal;

import java.util.Arrays;

public class MenurenewalTest {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};
        String[] result = solution.solution(orders, course);
        System.out.println("result = " + Arrays.toString(result) );
    }
}
