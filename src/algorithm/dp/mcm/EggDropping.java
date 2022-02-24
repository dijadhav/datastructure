package algorithm.dp.mcm;

import java.util.HashMap;
import java.util.Map;

public class EggDropping {
	private static Map<String, Integer> map = new HashMap<>();
	private static int[][] dp;

	public static void main(String[] args) {
		int f = 2000;
		int e = 4;
		dp = new int[e + 1][f + 1];
		for (int i = 0; i < e + 1; i++) {
			for (int j = 0; j < f + 1; j++) {
				dp[i][j] = -1;
			}
		}
		// System.out.println("Critical Floor: " + solve(f, e));
		System.out.println("Critical Floor Memoize: " + solveMemoize1(f, e));

	}

	private static int solve(int f, int e) {
		/** Start Base Condition **/

		if (f == 0 || f == 1 || e == 0 || e == 1)
			return f;

		int ans = Integer.MAX_VALUE;
		for (int k = 1; k < f; k++) {
			int temp = 1 + Math.max(solve(k - 1, e - 1), solve(f - k, e));
			ans = Math.min(ans, temp);
		}
		return ans;
	}

	private static int solveMemoize(int f, int e) {
		/** Start Base Condition **/

		if (f == 0 || f == 1 || e == 0 || e == 1)
			return f;

		String key = f + "_" + e;
		if (map.containsKey(key))
			return map.get(key);
		int ans = Integer.MAX_VALUE;
		for (int k = 1; k < f; k++) {
			int temp = 1 + Math.max(solveMemoize(k - 1, e - 1), solveMemoize(f - k, e));
			ans = Math.min(ans, temp);
		}
		map.put(key, ans);
		return ans;
	}

	private static int solveMemoize1(int f, int e) {
		/** Start Base Condition **/

		if (f == 0 || f == 1 || e == 0 || e == 1)
			return f;
		if (dp[e][f] != -1)
			return dp[e][f];

		int ans = Integer.MAX_VALUE;
		for (int k = 1; k < f; k++) {
			int down = 0;
			if (dp[e - 1][k - 1] != -1)
				down = dp[e - 1][k - 1];
			else {
				down = solveMemoize1(k - 1, e - 1);
				dp[e - 1][k - 1] = down;
			}
			int up = 0;
			if (dp[e][f - k] != -1)
				up = dp[e][f - k];
			else {
				up = solveMemoize1(f - k, e);
				dp[e][f - k] = up;
			}
			int temp = 1 + Math.max(down, up);
			ans = Math.min(ans, temp);
		}
		dp[e][f] = ans;
		return ans;
	}
	

}
