package algorithm.dp.mcm;

import java.util.HashMap;
import java.util.Map;

public class EvaluateBooleanExpression {
	public static void main(String[] args) {
		System.out.println(countWays(35, "T|F^F&T|F^F^F^T|T&T^T|F^T^F&F^T|T^F"));
	}

	static int countWays(int N, String S) {
		if (N == 0 || S == null || S.trim().isEmpty())
			return 0;
		Map<String, Integer> map = new HashMap<>();
		return solve(S, 0, N - 1, true, map);
	}

	private static int solve(String S, int i, int j, boolean isTrue, Map<String, Integer> map) {

		if (i > j)
			return 0;
		if (i == j) {
			if (isTrue) {
				return S.charAt(i) == 'T' ? 1 : 0;
			} else {
				return S.charAt(i) == 'F' ? 1 : 0;
			}
		}
		String key = i + "_" + j + "_" + isTrue;
		if (map.containsKey(key))
			return map.get(key);
		int ans = 0;
		for (int k = i + 1; k <= j - 1; k += 2) {
			int rt = solve(S, i, k - 1, true, map);
			int rf = solve(S, i, k - 1, false, map);
			int lt = solve(S, k + 1, j, true, map);
			int lf = solve(S, k + 1, j, false, map);
			if (S.charAt(k) == '&') {
				if (isTrue) {
					ans += rt * lt;
				} else {
					ans += rf * lf + rt * lf + rf * lt;
				}
			} else if (S.charAt(k) == '|') {
				if (isTrue) {
					ans += rt * lt + rt * lf + rf * lt;
				} else {
					ans += rf * lf;
				}
			} else if (S.charAt(k) == '^') {
				if (isTrue) {
					ans += rt * lf + rf * lt;
				} else {
					ans += rt * lt + rf * lf;
				}
			}
		}
		map.put(key, ans%1003);
		return ans%1003;
	}
}
