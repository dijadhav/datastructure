package algorithm.dp.lcs;

/**
 * @author dijadhav
 *
 */
public class LongestCommonSubSequence {
	private static int dp[][];

	public static void main(String[] args) {
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";
		int n = s1.length();
		int m = s2.length();
		dp = new int[n + 1][m + 1];
		System.out.println("Longest Common Subsequence Using Recurssion:" + lcsRecurssion(s1, s2, n, m));
		System.out.println("Longest Common Subsequence Using Memoization:" + lcsMemoization(s1, s2, n, m));
		System.out.println("Longest Common Subsequence Using TopDown:" + lcsTopDown(s1, s2, n, m));
	}

	private static int lcsRecurssion(String s1, String s2, int n, int m) {
		if (n == 0 || m == 0)
			return 0;
		if (s1.charAt(n - 1) == s2.charAt(m - 1))
			return 1 + lcsRecurssion(s1, s2, n - 1, m - 1);
		else {
			return Math.max(lcsRecurssion(s1, s2, n - 1, m), lcsRecurssion(s1, s2, n, m - 1));
		}
	}

	private static int lcsMemoization(String s1, String s2, int n, int m) {
		if (n == 0 || m == 0)
			return 0;
		if (dp[n][m] != 0) {
			return dp[n][m];
		}
		if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
			dp[n][m] = 1 + lcsRecurssion(s1, s2, n - 1, m - 1);
			return dp[n][m];
		} else {
			dp[n][m] = Math.max(lcsRecurssion(s1, s2, n - 1, m), lcsRecurssion(s1, s2, n, m - 1));
			return dp[n][m];
		}
	}

	private static int lcsTopDown(String s1, String s2, int n, int m) {
		if (n == 0 || m == 0)
			return 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
			}
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[n][m];
	}
}
