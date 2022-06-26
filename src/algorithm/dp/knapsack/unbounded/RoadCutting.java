package algorithm.dp.knapsack.unbounded;

public class RoadCutting {

	public static void main(String[] args) {
		int arr[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
		System.out.println("Maximum prices of rod cutting:" + rodcutting(arr, arr.length));
	}

	private static int rodcutting(int[] prices, int n) {
		int lens[] = new int[n];
		for (int i = 0; i < n; i++) {
			lens[i] = i + 1;
		}
		int m = prices.length;
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				}
			}
		}
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (lens[i - 1] <= j) {
					dp[i][j] = Math.max(prices[i - 1] + dp[i][j - lens[i - 1]], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[m][n];
	}

}
