package besttimetobuyandsellstock;

public class Solution {
    public int maxProfit(int[] prices) {

      int profit = 0;
      int minPrice = 10001;

      for(int price: prices) {
          minPrice = Math.min(minPrice, price);
          profit = Math.max(profit,  price - minPrice);
      }
      return profit;
    }
}
