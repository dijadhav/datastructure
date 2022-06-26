package algorithm.dp.knapsack;

public class EqualSumPartision {

	public static void main(String[] args) {
		int arr[] = { 0, 3, 8, 9, 2 };
		System.out.println(subsetSum(arr, 0));
		System.out.println(equalSumPartition(arr, arr.length));
	}

	private static boolean subsetSum(int[] arr, int sum) {
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		if (sum % 2 != 0) {
			return false;
		}
		return hasSubsetSumRecursive(arr, sum / 2, arr.length - 1);
	}

	private static boolean hasSubsetSumRecursive(int[] arr, int sum, int n) {
		if (n == 0 && sum == 0)
			return true;
		if (n == 0 && sum != 0)
			return false;
		if (n != 0 && sum == 0)
			return true;

		if (arr[n] <= sum) {
			return hasSubsetSumRecursive(arr, sum - arr[n], n - 1) || hasSubsetSumRecursive(arr, sum, n - 1);
		}
		return hasSubsetSumRecursive(arr, sum, n - 1);
	}

	private static boolean equalSumPartition(int[] arr, int N) {
		int sum = 0;
		for (int num : arr) {
			sum += num;
		}
		if (sum % 2 != 0)
			return false;
		sum = sum / 2;

		if (N == 0 && sum == 0)
			return true;
		if (N != 0 && sum == 0)
			return false;
		if (N == 0 && sum != 0)
			return true;

		boolean dp[][] = new boolean[N + 1][sum + 1];
		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0) {
					dp[i][j] = false;
				}
				if (j == 0) {
					dp[i][j] = true;
				}

			}
		}

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[N][sum];
	}
}
