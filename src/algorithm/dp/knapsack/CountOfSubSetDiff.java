package algorithm.dp.knapsack;

public class CountOfSubSetDiff {
	public static void main(String[] args) {
		int[] arr = { 1,1,2,3 };
		int diff = 1;
		int sum = 0;
		int n = arr.length;
		for (int i = 0; i < n; i++) {// O(n)
			sum += arr[i];
		}
		if (sum < Math.abs(diff))
			return;

		System.out.println("Count of subset diiference for given diff:" + countOfSubsetSum(arr, (sum + diff) / 2));
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
			for (int j = 0; j < sum + 1; j++) {
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
