package algorithm.dp.lcs;

public class ShortestSuperSequence {
	private static int dp[][];

	public static void main(String[] args) {
		String s1 = "abac";
		String s2 = "cab";
		int n = s1.length();
		int m = s2.length();
		dp = new int[n + 1][m + 1];
		System.out.println("Length of Shortest super sequece:" + (m + n - lcsRecurssion(s1, s2, n, m)));
		System.out.println("Shortest of super sequece:" + printSCS(s1, s2, n, m));
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

	private static String printSCS(String s1, String s2, int n, int m) {
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
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		int i = n, j = m;
		while (i > 0 || j > 0) {
			if(i==0 || j==0)
				break;
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
				sb.append(s1.charAt(i - 1));
				i--;
				j--;
			} else {
				if (dp[i - 1][j] > dp[i][j - 1]) {
					sb.append(s1.charAt(i - 1));
					i--;
				} else {
					sb.append(s2.charAt(j - 1));
					j--;
				}
			}
		}
		while (i > 0) {
			sb.append(s1.charAt(i - 1));
			i--;
		}
		while (j > 0) {
			sb.append(s2.charAt(j - 1));
			j--;
		}
		return sb.reverse().toString();
	}

}
