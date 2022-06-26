package algorithm.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {
	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(solve(s, t));
	}

	private static String solve(String s, String t) {
		String result = "";
		int n = s.length();
		int m = t.length();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < m; i++) {
			char ch = t.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		int i = 0, j = 0, startIndex = 0, len = Integer.MAX_VALUE;
		int count = map.size();
		while (j < n) {
			char ch = s.charAt(j);
			if (map.containsKey(ch)) {
				int cnt = map.get(ch);
				cnt--;
				if (cnt == 0) {
					count--;
				}
				map.put(ch, cnt);
			}
			if (count > 0)
				j++;
			else if (count == 0) {
				if (j - i + 1 < len) {
					len = j - i + 1;
					startIndex = i;
					result = s.substring(startIndex, startIndex + len);
				}
				while (count == 0) {
					char c = s.charAt(i);
					if (map.containsKey(c)) {
						int cnt = map.get(c);
						cnt++;
						map.put(c, cnt);
						if (cnt == 1) {
							count++;
							i++;
						} else {
							i++;
							if (j - i + 1 < len) {
								len = j - i + 1;
								startIndex = i;
								result = s.substring(startIndex, startIndex + len);
							}
						}
					} else {
						i++;
						if (j - i + 1 < len) {
							len = j - i + 1;
							startIndex = i;
							result = s.substring(startIndex, startIndex + len);
						}
					}
				}
				j++;
			}
		}
		return (len == Integer.MAX_VALUE ? "" : result);
	}
}
