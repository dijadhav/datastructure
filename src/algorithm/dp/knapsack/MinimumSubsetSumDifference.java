package algorithm.dp.knapsack;

import java.util.ArrayList;
import java.util.List;

/**
 * S1+S2 = sum
 * |S1-S2|=min
 * 
 * 2S1=sum+min
 * min=sum-2S1 
 * @author dijadhav
 *
 */
public class MinimumSubsetSumDifference {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 7 };
		System.out.println("Minimum subset sum difference exist:" + minimumSubsetSumDifference(arr));
	}

	private static int minimumSubsetSumDifference(int[] arr) {
		int sum = 0;
		int n = arr.length;
		for (int i = 0; i < n; i++) {// O(n)
			sum += arr[i];
		}

		boolean[][] dp = new boolean[n + 1][sum + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0)
					dp[i][j] = false;
				if (j == 0)
					dp[i][j] = true;
			}
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (arr[i - 1] <= j)
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
				else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		List<Integer> list = new ArrayList<>();
		for (int j = 0; j < dp[0].length / 2; j++) {
			if (dp[n][j]) {
				list.add(j);
			}
		}
		int min = Integer.MAX_VALUE;
		for (int num : list) {
			min = Math.min(min, sum - 2 * num);
		}
		return min;
	}

}
