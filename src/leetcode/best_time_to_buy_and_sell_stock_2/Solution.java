package leetcode.best_time_to_buy_and_sell_stock_2;

public class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;

        int buy = prices[0];
        int sell = prices[0];
        for(int i=1; i<prices.length; i++) {
            if(sell < prices[i]) {
                sell = prices[i];
            } else {
                answer += sell - buy;
                buy = prices[i];
                sell = prices[i];
            }
        }
        answer += sell - buy;

        return answer;
    }
}
