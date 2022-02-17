package algorithm.dp.knapsack;

public class SubsetSum {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 7, 9, 11 };
		int sum = 18;
		System.out.println(hasSubsetSumRecursive(arr, sum, arr.length - 1));
		System.out.println(hasSubsetSumBottomUp(arr, sum));

	}

	/**
	 * This recursive approach for subset sums
	 * 
	 * @param arr
	 * @param sum
	 * @param n
	 * @return
	 */
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

	/**
	 * This recursive approach for subset sums
	 * 
	 * @param arr
	 * @param sum
	 * @param n
	 * @return
	 */
	private static boolean hasSubsetSumBottomUp(int[] arr, int sum) {
		int n = arr.length;
		boolean dp[][] = new boolean[n + 1][sum + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0) {
					dp[i][j] = false;
				}
				if (j == 0) {
					dp[i][j] = true;
				}
			}
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (dp[i][j]) {
					System.out.print("T ");
				} else {
					System.out.print("F ");
				}
			}
			System.out.println();
		}
		return dp[n][sum];
	}
}
