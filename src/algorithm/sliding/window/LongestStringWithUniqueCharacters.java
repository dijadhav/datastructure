package algorithm.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class LongestStringWithUniqueCharacters {

	public static void main(String[] args) {
		System.out.println(longestSubstrDistinctChars("fasdfawefuwehjfajdsbvbvbbbcbbbbbbbbcbksfhskjdhaflkhjasdlkfha"));
	}

	static int longestSubstrDistinctChars(String S) {
		int i = 0;
		int j = 0;
		int maxLen = 0;
		int N = S.length();
		Map<Character, Integer> map = new HashMap<>();
		while (j < N) {
			int count = 0;
			if (map.containsKey(S.charAt(j))) {
				count = map.get(S.charAt(j));
			}
			count++;
			map.put(S.charAt(j), count);
			if (map.size() == j - i + 1) {
				if (j - i + 1 > maxLen) {
					maxLen = j - i + 1;
				}
				j++;
			} else {
				while (map.size() < j - i + 1) {
					count = 0;
					if (map.containsKey(S.charAt(i))) {
						count = map.get(S.charAt(i));
					}
					count--;
					if (count == 0)
						map.remove(S.charAt(i));
					else
						map.put(S.charAt(i), count);
					i++;
				}
				j++;
			}
		}
		return maxLen;
	}

}
