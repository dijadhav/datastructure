package algorithm.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class CountOccurranceOfAnagram {

	public static void main(String[] args) {
		System.out.println("Count of anagrams:" + search("abc", "cbaebabacd"));
	}

	private static int search(String pat, String txt) {
		if (null == pat || pat.trim().isEmpty())
			return 0;
		if (null == txt || txt.trim().isEmpty())
			return 0;
		pat = pat.trim();
		txt = txt.trim();

		int n = txt.length();
		int k = pat.length();
		if (k > n) {
			return 0;
		}
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < k; i++) {
			int cnt = 0;
			if (map.containsKey(pat.charAt(i))) {
				cnt = map.get(pat.charAt(i));
			}
			cnt++;
			map.put(pat.charAt(i), cnt);
		}
		int count = map.size();
		int ans = 0, i = 0, j = 0;

		while (j < n) {
			if (map.containsKey(txt.charAt(j))) {
				int cnt = map.get(txt.charAt(j));
				cnt--;
				map.put(txt.charAt(j), cnt);
				if (cnt == 0)
					count--;
			}

			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				if (count == 0) {
					ans++;
				}
				if (map.containsKey(txt.charAt(i))) {
					int cnt = map.get(txt.charAt(i));
					cnt++;
					map.put(txt.charAt(i), cnt);
					if (cnt == 1)
						count++;
				}
				i++;
				j++;
			}
		}
		return ans;
	}
}
