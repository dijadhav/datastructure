package algorithm;

import java.util.HashMap;
import java.util.Map;

public class CheckAnagram {

	public static void main(String[] args) {
		System.out.println("Does string anagrams:" + isAnagram("rat", "car"));

	}

	public static boolean isAnagram(String s, String t) {

		if (!isValid(s) && !isValid(t))
			return true;
		if (!isValid(s) || !isValid(t))
			return false;

		s = s.trim();
		t = t.trim();

		int n = s.length();
		int k = t.length();
		if (k != n) {
			return false;
		}

		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < k; i++) {
			int cnt = 0;
			if (map.containsKey(s.charAt(i))) {
				cnt = map.get(s.charAt(i));
			}
			cnt++;
			map.put(s.charAt(i), cnt);
		}
		int count = map.size();
		int j = 0;
		while (j < n) {
			if (map.containsKey(t.charAt(j))) {
				int cnt = map.get(t.charAt(j));
				cnt--;
				map.put(t.charAt(j), cnt);
				if (cnt == 0)
					count--;
			}
			j++;
		}
		return count == 0;
	}

	private static boolean isValid(String s) {
		return s != null && !s.trim().isEmpty();
	}

}
