package algorithm.buyandsell;

/**
 * Buy and sell the stock to get the maximum profit. Single transaction is
 * allowed.Find the maximum profit we can get by selling at point,also find
 * maximum buy at a given point.
 * 
 * @author dijadhav
 *
 */
public class BuyAndSellKTransaction {

	/**
	 * Main method of the application.
	 * 
	 * @param args - Array of command line arguments.
	 */
	public static void main(String[] args) {
		int[] prices = { 30, 40, 43, 50, 45, 20, 26, 40, 80, 50, 30, 10, 20, 40, 45, 71, 50, 55 };
		System.out.println("Maximum profit in two transtion:" + maxProfit(prices, prices.length, 3));
	}

	/**
	 * Method finds the maximum profit after buy and sell . Only two transaction is
	 * allowed.
	 * 
	 * @param prices - Array of stock prices
	 * @param n      - Number stock prices
	 * @return - Maximum profit
	 */
	static int maxProfit(int[] prices, int n, int k) {
		int dp[][] = new int[k + 1][n];
		for (int i = 1; i < k + 1; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 1; j < n; j++) {
				max = Math.max(max, dp[i - 1][j - 1] - prices[j - 1]);
				/**
				 * O(n3) time complexity. for (int m = 0; m < j; m++) { int p = prices[j] -
				 * prices[m]; max = Math.max(max, p + dp[i - 1][m]); }
				 */

				dp[i][j] = Math.max(max + prices[j], dp[i][j - 1]);
			}
		}
		return dp[k][n - 1];
	}

}
