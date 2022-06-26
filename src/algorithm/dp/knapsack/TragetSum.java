package algorithm.dp.knapsack;

public class TragetSum {

	public static void main(String[] args) {

	}

	static int countSubsetDiff(int arr[], int sum) {
		int n = arr.length;
		int[][] dp = new int[n + 1][sum + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0)
					dp[i][j] = 0;
				if (j == 0)
					dp[i][j] = 1;
			}
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - arr[j]] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[n][sum];
	}

}
