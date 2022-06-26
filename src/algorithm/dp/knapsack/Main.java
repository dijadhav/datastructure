package algorithm.dp.knapsack;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		int[] wt = new int[N];
		int[] vals = new int[N];
		for (int i = 0; i < N; i++) {
			wt[i] = sc.nextInt();
			vals[i] = sc.nextInt();
		}
		if (N != 0 && W != 0) {
			long dp[][] = new long[N + 1][W + 1];
			for (int i = 0; i < N + 1; i++) {
				for (int j = 0; j < W + 1; j++) {
					if (i == 0 || j == 0) {
						dp[i][j] = 0;
					}
				}
			}
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < W + 1; j++) {
					if (wt[i - 1] <= j) {
						dp[i][j] = Math.max(vals[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
					} else {
						dp[i][j] = dp[i - 1][j];
					}

				}
			}
			System.out.println(dp[N][W]);
		}
		sc.close();

	}

}