package algorithm.buyandsell;

/**
 * Buy and sell the stock to get the maximum profit. Infinite transactions are
 * allowed with cool down period
 * 
 * We maintain old buy ,sold and coldown state and new buy ,sold and coldown
 * state.
 * 
 * @author dijadhav
 *
 */
public class BuyAndSellStockInfiniteTransctionWithCooldown {

	/**
	 * Main method of the application.
	 * 
	 * @param args - Array of command line arguments.
	 */
	public static void main(String[] args) {
		int[] prices = { 1, 3, 2, 8, 4, 9 };
		System.out.println("Maximum profit in infinite transtion with cool down:" + maxProfit(prices));
	}

	/**
	 * Method finds the maximum profit after buy and sell.Infinite transactions are
	 * allowed.
	 * 
	 * @param prices - Array of stock prices
	 * @param n      - Number stock prices
	 * @return Total profit
	 */
	static public int maxProfit(int[] prices) {
		int n = prices.length;
		int obsp = -prices[0];
		int ossp = 0;
		int ocsp = 0;
		for (int i = 1; i < n; i++) {
			int nbsp = 0;
			int nssp = 0;
			int ncsp = 0;
			int price = prices[i];

			if (ocsp - price > obsp) {
				nbsp = ocsp - price;
			} else {
				nbsp = obsp;
			}

			if (obsp + price > ossp) {
				nssp = obsp + price;
			} else {
				nssp = ossp;
			}

			if (ossp > ocsp) {
				ncsp = ossp;
			} else {
				ncsp = ocsp;
			}

			obsp = nbsp;
			ossp = nssp;
			ocsp = ncsp;
		}
		return ossp;
	}

}
