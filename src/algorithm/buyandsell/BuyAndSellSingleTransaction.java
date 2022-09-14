package algorithm.buyandsell;

/**
 * Buy and sell the stock to get the maximum profit. Single transaction is
 * allowed.Every prices is compared with the previous minimum price for maximum
 * profit. Check current day's maximum profit is overall maximum profit or not.
 * If yes then update overall profit.
 * 
 * @author dijadhav
 *
 */
public class BuyAndSellSingleTransaction {

	/**
	 * Main method of the application.
	 * 
	 * @param args - Array of command line arguments.
	 */
	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		System.out.println("Maximum profit in single transtion:" + maxProfit(prices, prices.length));
	}

	/**
	 * Method finds the maximum profit after buy and sell . Only single transaction
	 * is allowed.
	 * 
	 * @param prices - Array of stock prices
	 * @param n      - Number stock prices
	 * @return - Maximum profit
	 */
	static int maxProfit(int[] prices, int n) {
		int min = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int i = 0; i < n; i++) {
			// Find the previous minimum prices to buy;
			if (prices[i] < min) {
				min = prices[i];
			}
			int currentMax = prices[i] - min;// Current maximum profit.
			maxProfit = Math.max(maxProfit, currentMax);
		}
		return maxProfit;
	}

}
