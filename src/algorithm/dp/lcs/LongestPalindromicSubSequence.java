package algorithm.dp.lcs;

import java.util.Iterator;

public class LongestPalindromicSubSequence {

	public static void main(String[] args) {
		String s = "bbbab";
		System.out.println(lcs(s, new StringBuilder(s).reverse().toString()));
	}

	private static int lcs(String s, String t) {
		int n = s.length();
		if (n == 0)
			return 0;
		if (s.equals(t))
			return n;
		int dp[][] = new int[n + 1][n + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
			}
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1))
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
			}
		}
		return dp[n][n];
	}

}
