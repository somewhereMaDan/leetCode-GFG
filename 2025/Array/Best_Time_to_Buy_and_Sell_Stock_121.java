public class Best_Time_to_Buy_and_Sell_Stock_121 {
  public static int maxProfit(int[] prices) {
    int maxProfit = 0;
    int buy = 0;
    int sell = 1;

    for (int i = 0; i < prices.length - 1; i++) {
      if ((prices[sell] > prices[buy])) {
        int profit = prices[sell] - prices[buy];
        maxProfit = Math.max(profit, maxProfit);
      } else {
        buy = sell;
      }
      sell++;
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    int[] prices = {7, 1, 5, 3, 6, 10};
    System.out.println(maxProfit(prices));
  }
}
