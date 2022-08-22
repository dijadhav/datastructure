package algorithm.dp;

/**
 * https://www.geeksforgeeks.org/edit-distance-dp-5/?ref=lbp
 * 
 * @author dijadhav
 *
 */
public class EditDistance {

	public static void main(String[] args) {
		String s = "geek";
		String t = "geesk";
		int n = s.length();
		int m = t.length();
		int dp[][] = new int[n + 1][m + 1];

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < m + 1; j++) {
				if (i == 0)
					dp[i][j] = j;
				if (j == 0)
					dp[i][j] = i;
			}
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					int f1 = 1 + dp[i - 1][j - 1];
					int f2 = 1 + dp[i][j - 1];
					int f3 = 1 + dp[i - 1][j];
					dp[i][j] = Math.min(f1, Math.min(f2, f3));
				}
			}
		}
		System.out.println(dp[n][m]);
	}

}
