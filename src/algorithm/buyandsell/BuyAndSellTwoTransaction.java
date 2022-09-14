package algorithm.buyandsell;

/**
 * Buy and sell the stock to get the maximum profit. Single transaction is
 * allowed.Find the maximum profit we can get by selling at point,also find
 * maximum buy at a given point.
 * 
 * @author dijadhav
 *
 */
public class BuyAndSellTwoTransaction {

	/**
	 * Main method of the application.
	 * 
	 * @param args - Array of command line arguments.
	 */
	public static void main(String[] args) {
		int[] prices = { 30, 40, 43, 50, 45, 20, 26, 40, 80, 50, 30, 10, 20, 40, 45, 71, 50, 55 };
		System.out.println("Maximum profit in k transtion:" + maxProfit(prices, prices.length));
	}

	/**
	 * Method finds the maximum profit after buy and sell . Only two transaction is
	 * allowed.
	 * 
	 * @param prices - Array of stock prices
	 * @param n      - Number stock prices
	 * @return - Maximum profit
	 */
	static int maxProfit(int[] prices, int n) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		// Find the max profit can get by selling at each point
		int sells[] = new int[n];
		int min = Integer.MAX_VALUE;
		int profit = 0;
		for (int i = 0; i < n; i++) {
			if (prices[i] < min)
				min = prices[i];
			int diff = prices[i] - min;
			profit = Math.max(profit, diff);
			sells[i] = profit;
		}
		// Find the max profit can get by buying at each point
		int buys[] = new int[n];
		int max = 0;
		profit = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (prices[i] > max)
				max = prices[i];
			int diff = max - prices[i];
			profit = Math.max(profit, diff);
			buys[i] = profit;
		}
		// Get max profit by adding sell and buy at a point.
		max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, sells[i] + buys[i]);

		}
		return max;
	}

}
