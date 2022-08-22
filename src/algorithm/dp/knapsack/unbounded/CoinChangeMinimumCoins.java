package algorithm.dp.knapsack.unbounded;

public class CoinChangeMinimumCoins {
	public static void main(String[] args) {
		int[] coins = { 1, 2, 3};
		int amount = 5;
		System.out.println("Minimum coins:" + minimumCoins(coins, amount));
	}

	private static int minimumCoins(int[] coins, int amount) {
		int n = coins.length;
		int dp[][] = new int[n + 1][amount + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < amount + 1; j++) {
				if (i == 0)
					dp[0][j] = Integer.MAX_VALUE;
				if (j == 0)
					dp[i][0] =0;
			}
		}
		
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < amount + 1; j++) {
				if (coins[i - 1] <= j) {
					dp[i][j] = Math.min(1+dp[i][j - coins[i - 1]== Integer.MAX_VALUE?0:1], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		int ans= dp[n][amount];
		return Math.abs(ans)==Integer.MAX_VALUE?-1:ans;
	}
}