package algorithm.dp.knapsack;

public class Knapsack01 {

	public static void main(String[] args) {
		int[] vals = { 1, 2, 3 };
		int[] wts = { 4, 5, 1 };
		int W = 4;
		int n = 3;
		int dp[] = new int[n];
		for (int i = 0; i < n; i++) {
			dp[i] = -1;
		}
		System.out.println("Knapsack Recusive:" + knapSack(W, wts, vals, n));
		System.out.println("Knapsack Recusive Memoization:" + knapSack(W, wts, vals, n, dp));
		System.out.println("Knapsack DP:" + knapSackDP(W, wts, vals, n));

	}

	static int knapSackDP(int W, int wt[], int val[], int n) {
		if (n == 0 || W == 0)
			return 0;
		int[][] dp = new int[n + 1][W + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < W + 1; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
			}
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < W + 1; j++) {
				if (wt[i - 1] <= j) {
					dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
				} else
					dp[i][j] = dp[i - 1][j];
			}
		}
		return dp[n][W];
	}

	static int knapSack(int W, int wt[], int val[], int n) {
		if (n == 0 || W == 0)
			return 0;
		if (wt[n - 1] <= W)
			return Math.max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1), knapSack(W, wt, val, n - 1));
		return knapSack(W, wt, val, n - 1);
	}

	static int knapSack(int W, int wt[], int val[], int n, int[] dp) {
		if (n == 0 || W == 0)
			return 0;
		if (dp[n - 1] != -1)
			return dp[n - 1];
		if (wt[n - 1] <= W)
			dp[n - 1] = Math.max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1), knapSack(W, wt, val, n - 1));
		else
			dp[n - 1] = knapSack(W, wt, val, n - 1);
		return dp[n - 1];
	}

}
