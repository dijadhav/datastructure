package algorithm.dp.mcm;

public class PalindromePartition {
	private static int[][] dp;

	public static void main(String[] args) {
		String s = "abac";
		int i = 0;
		int j = s.length() - 1;
		dp = new int[s.length() + 1][s.length() + 1];
		for (int j2 = 0; j2 < dp.length; j2++) {
			for (int k = 0; k < dp[0].length; k++) {
				dp[j2][k] = -1;
			}
		}
		System.out.println("Cost using recursive:" + solveRecursive(s, i, j));
		System.out.println("Cost using Memoization:" + solveMemoization(s, i, j));

	}

	private static int solveMemoization(String s, int i, int j) {
		if (isPalindrom(s, i, j))
			return 0;
		if (dp[i][j] != -1)
			return dp[i][j];
		int ans = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int s1 = solveMemoization(s, i, k);
			dp[i][k] = s1;
			int s2 = solveMemoization(s, k + 1, j);
			dp[k + 1][j] = s2;
			int temp = s1 + s2 + 1;
			ans = Math.min(ans, temp);
		}
		return ans;
	}

	private static int solveRecursive(String s, int i, int j) {
		if (isPalindrom(s, i, j))
			return 0;
		int ans = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int temp = solveRecursive(s, i, k) + solveRecursive(s, k + 1, j) + 1;
			ans = Math.min(ans, temp);
		}
		return ans;
	}

	private static boolean isPalindrom(String s, int i, int j) {
		if (i >= j)
			return true;
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString().equals(s);
	}

}
