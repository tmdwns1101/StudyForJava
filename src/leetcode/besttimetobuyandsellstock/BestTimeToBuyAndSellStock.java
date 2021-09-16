package leetcode.besttimetobuyandsellstock;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] prices = {7,1,5,3,6,4};
        int[] prices = {2,4,1};
        int result = solution.maxProfit(prices);
        System.out.println("result = " + result);
    }
}
