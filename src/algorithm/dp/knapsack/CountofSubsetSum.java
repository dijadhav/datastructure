package algorithm.dp.knapsack;

public class CountofSubsetSum {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 3 };
		int sum = 4;
		System.out.println("Count of subset sum for given sum:" + solve(arr, arr.length, sum));
		System.out.println("Count of subset sum for given sum:" + countOfSubsetSum(arr, sum));
	}

	private static int solve(int arr[], int n, int sum) {
		if (sum == 0)
			return 1;
		if (n == 0)
			return 0;
		if (arr[n - 1] <= sum)
			return 1 +solve(arr, n - 1, sum - arr[n - 1]);
		return solve(arr, n - 1, sum);
	}

	private static int countOfSubsetSum(int[] arr, int sum) {
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
			for (int j = 1; j < sum + 1; j++) {
				if (arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][sum];
	}
}
