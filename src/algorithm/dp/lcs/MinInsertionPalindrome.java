package algorithm.dp.lcs;

public class MinInsertionPalindrome {
	private static int dp[][];

	public static void main(String[] args) {
		System.out.println("Minimum Deletion:" + minDeletions("agbcba"));
	}

	public static int minDeletions(String s) {
		StringBuilder sb = new StringBuilder(s);
		String s1 = sb.reverse().toString();
		int n = s.length();
		int m = s1.length();
		dp = new int[n + 1][m + 1];
		int lcs = lcs(s, s1, n, m);
		return m - lcs;
	}

	private static int lcs(String s1, String s2, int n, int m) {
		if (n == 0 || m == 0)
			return 0;

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < m + 1; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
			}
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
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
