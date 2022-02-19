package algorithm.dp.mcm;

public class MatrixChainMuliplication {
	private static int[][] dp;

	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 30 };
		int i = 1;
		int j = arr.length - 1;
		dp = new int[arr.length + 1][arr.length + 1];
		for (int j2 = 0; j2 < dp.length; j2++) {
			for (int k = 0; k < dp[0].length; k++) {
				dp[j2][k] = -1;
			}
		}
		System.out.println("Cost using recursive:" + solveRecursive(arr, i, j));

		System.out.println("Cost using Memoization:" + solveMemoization(arr, i, j));
	}

	private static int solveMemoization(int[] arr, int i, int j) {
		if (i >= j)
			return 0;
		if (dp[i][j] != -1)
			return dp[i][j];
		int ans = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int s1 = solveMemoization(arr, i, k);
			dp[i][k] = s1;
			int s2 = solveMemoization(arr, k + 1, j);
			dp[k + 1][j] = s2;
			int temp = s1 + s2 + (arr[i - 1] * arr[k] * arr[j]);
			ans = Math.min(ans, temp);
		}
		return ans;
	}

	private static int solveRecursive(int[] arr, int i, int j) {
		if (i >= j)
			return 0;
		int ans = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int temp = solveRecursive(arr, i, k) + solveRecursive(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);
			ans = Math.min(ans, temp);
		}
		return ans;
	}

}
