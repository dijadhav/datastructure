package algorithm.dp.lcs;

public class LongestPalindromicSubString {
	private static int dp[][];

	public static void main(String[] args) {
		System.out.println("Longest Palindromic SubString:" + longestPalindromeSubstring("babad"));
		System.out.println("Longest Palindromic SubString:" + longestPalindromeSubstring("cbbd"));
		System.out.println("Longest Palindromic SubString:" + longestPalindromeSubstring("aacabdkacaa"));
	}

	public static String longestPalindromeSubstring(String s) {
		StringBuilder sb = new StringBuilder(s);
		String s1 = sb.reverse().toString();
		int n = s.length();
		int m = s1.length();
		dp = new int[n + 1][m + 1];
		return lcs(s, s1, n, m);
	}

	private static String lcs(String s1, String s2, int n, int m) {
		if (n == 0 || m == 0)
			return "";

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else {
					dp[i][j] = 0;
				}
			}
		}
		int i = n;
		int j = m;
		StringBuilder sb = new StringBuilder();
		while (i > 0 || j > 0) {
			if (i == 0 || j == 0)
				break;
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
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
		return sb.toString();
	}
}
