package algorithm.buyandsell;

/**
 * Buy and sell the stock to get the maximum profit. Infinite transactions are
 * allowed.
 * 
 * We maintain old buy and sold states and new buy and sold state.
 * 
 * @author dijadhav
 *
 */
public class BuyAndSellStockInfiniteTransctionWithFee {

	/**
	 * Main method of the application.
	 * 
	 * @param args - Array of command line arguments.
	 */
	public static void main(String[] args) {
		int[] prices = { 1, 3, 2, 8, 4, 9 };
		System.out.println(
				"Maximum profit in infinite transtion with transaction fee:" + maxProfit(prices, prices.length, 2));
	}

	/**
	 * Method finds the maximum profit after buy and sell.Infinite transactions are
	 * allowed.
	 * 
	 * @param prices - Array of stock prices
	 * @param n      - Number stock prices
	 * @return Total profit
	 */
	static int maxProfit(int[] prices, int n, int fee) {
		int ossp = 0;
		int obsp = -prices[0];
		for (int i = 1; i < n; i++) {
			int price = prices[i];
			int nbsp = 0;
			int nssp = 0;
			if (ossp - price > obsp) {
				nbsp = ossp - price;
			} else {
				nbsp = obsp;
			}
			if (obsp + price - fee > ossp) {
				nssp = obsp + price - fee;
			} else {
				nssp = ossp;
			}
			obsp = nbsp;
			ossp = nssp;
		}
		return ossp;
	}

}
