package algorithm.dp.knapsack.unbounded;

public class CoinChangeMaxWays {
	public static void main(String[] args) {
		int[] coins = { 1, 2, 5 };
		int amount = 5;
		System.out.println("Max ways:" + count(coins, coins.length, amount));
	}

	private static int count(int[] coins, int n, int m) {
		int dp[][] = new int[n + 1][m + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0)
					dp[0][j] = 0;
				if (j == 0)
					dp[i][0] = 1;
			}
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (coins[i - 1] <= j)
					dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j];
			}
		}

		return dp[n][m];
	}
}
