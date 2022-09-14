package algorithm.buyandsell;

/**
 * Buy and sell the stock to get the maximum profit. Infinite transactions are
 * allowed. Increment the sell index if current price is greater than previous
 * price. else add the current profit in the total profit and update sell and
 * buy date.
 * 
 * @author dijadhav
 *
 */
public class BuyAndSellStockInfiniteTransction {

	/**
	 * Main method of the application.
	 * 
	 * @param args - Array of command line arguments.
	 */
	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		System.out.println("Maximum profit in infinite transtion:" + maxProfit(prices, prices.length));
		System.out.println("Maximum profit in infinite transtion:" + maxProfit1(prices, prices.length));
	}

	/**
	 * Method finds the maximum profit after buy and sell.Infinite transactions are
	 * allowed.
	 * 
	 * @param prices - Array of stock prices
	 * @param n      - Number stock prices
	 * @return - Maximum profit
	 */
	static int maxProfit(int[] prices, int n) {
		int maxProfit = 0;
		for (int i = 0; i < n - 1; i++) {
			if (prices[i + 1] > prices[i]) {
				maxProfit += prices[i + 1] - prices[i];
			}
		}
		return maxProfit;
	}

	/**
	 * Method finds the maximum profit after buy and sell.Infinite transactions are
	 * allowed.
	 * 
	 * @param prices - Array of stock prices
	 * @param n      - Number stock prices
	 * @return Total profit
	 */
	static int maxProfit1(int[] prices, int n) {
		int profit = 0;
		int sd = 0;
		int bd = 0;
		for (int i = 1; i < n; i++) {
			if (prices[i] > prices[i - 1]) {
				sd++;
			} else {
				profit += prices[sd] - prices[bd];
				sd = bd = i;
			}
		}
		profit += prices[sd] - prices[bd];
		return profit;
	}

}
