package algorithm.dp.knapsack;

public class TragetSum {

	public static void main(String[] args) {
		int A[] = new int[] { 1, 1, 1, 1, 1 };
		int target = 3;
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}
		if (sum < target || (target + sum) % 2 != 0)
			return;
		sum = (sum - target) / 2;
		System.out.println(countSubsetDiff(A, sum));
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
