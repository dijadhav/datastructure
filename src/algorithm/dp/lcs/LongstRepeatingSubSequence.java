package algorithm.dp.lcs;

public class LongstRepeatingSubSequence {
	private static int dp[][];

	public static void main(String[] args) {
		String s1 = "AABEBCDD";
		int n = s1.length();
		int m = n;
		dp = new int[n + 1][m + 1];
		System.out.println("Longst Repeating SubSequence:" + longestCommonPalindrome(s1, s1, n, m));
	}

	private static String longestCommonPalindrome(String s1, String s2, int n, int m) {
		if (n == 0 || m == 0)
			return "";

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < m + 1; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
			}
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1) && i != j) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		int i = n, j = m;
		StringBuilder sb = new StringBuilder();
		while (i > 0 || j > 0) {
			if (i == 0 || j == 0)
				break;
			if (s1.charAt(i - 1) == s2.charAt(j - 1) && i != j) {
				sb.append(s1.charAt(i - 1));
				i--;
				j--;
			} else {
				if (dp[i - 1][j] > dp[i][j - 1]) {
					i--;
				} else {
					j--;
				}
			}
		}
		return sb.reverse().toString();
	}

}
