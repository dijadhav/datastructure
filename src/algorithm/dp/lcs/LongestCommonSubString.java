package algorithm.dp.lcs;

public class LongestCommonSubString {
	private static int dp[][];

	public static void main(String[] args) {
		String s1 = "AGGTABMKFJINRKTE";
		String s2 = "GXTABKFJIRKTE";
		int n = s1.length();
		int m = s2.length();
		dp = new int[n + 1][m + 1];
		System.out.println("Longest Common Subsequence Using Recurssion:" + lcsRecurssion(s1, s2, n, m));
		System.out.println("Longest Common Subsequence Using Memoization:" + lcsMemoization(s1, s2, n, m));
		dp = new int[n + 1][m + 1];
		System.out.println("Longest Common Subsequence Using DP:" + lcsDP(s1, s2, n, m));
		System.out.println("Longest Common Subsequence Using Recurssion:" + lcsRecurssionPrint(s1, s2, n, m));
	}

	private static int lcsRecurssion(String s1, String s2, int n, int m) {
		if (n == 0 || m == 0)
			return 0;
		if (s1.charAt(n - 1) == s2.charAt(m - 1))
			return 1 + lcsRecurssion(s1, s2, n - 1, m - 1);
		else {
			return 0;
		}
	}

	private static String lcsRecurssionPrint(String s1, String s2, int n, int m) {
		if (n == 0 || m == 0)
			return "";
		if (s1.charAt(n - 1) == s2.charAt(m - 1))
			return lcsRecurssionPrint(s1, s2, n - 1, m - 1) + s1.charAt(n - 1);
		else {
			return "";
		}
	}

	private static int lcsMemoization(String s1, String s2, int n, int m) {
		if (n == 0 || m == 0)
			return 0;
		if (dp[n - 1][m - 1] != 0)
			return dp[n - 1][m - 1];
		if (s1.charAt(n - 1) == s2.charAt(m - 1))
			dp[n][m] = 1 + lcsMemoization(s1, s2, n - 1, m - 1);
		else {
			dp[n][m] = 0;
		}
		return dp[n][m];
	}

	private static int lcsDP(String s1, String s2, int n, int m) {
		if (n == 0 || m == 0)
			return 0;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else {
					dp[i][j] = 0;
				}
			}
		}
		return dp[n][m];
	}

}
