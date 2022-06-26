package algorithm.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class PickToy {

	public static void main(String[] args) {
		System.out.println(lenOfLongSubarr("abaccab", 2));
		System.out.println(solve("abaccab", 7, 2));

	}

	static int solve(String s, int n, int k) {
		if (n < k)
			return 0;
		int i = 0, j = 0, max = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		while (j < n) {
			char ch = s.charAt(j);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			if (map.size() == k) {
				max = Math.max(max, j - i + 1);
			} else {
				while (map.size() > k) {
					ch = s.charAt(i);
					int cnt = map.getOrDefault(ch, 0);
					cnt--;
					if (cnt <= 0) {
						map.remove(ch);
					} else {
						map.put(ch, cnt);
					}
					i++;
				}
			}
			j++;
		}
		return max;
	}

	// Function for finding maximum and value pair
	public static int lenOfLongSubarr(String S, int K) {
		int i = 0;
		int j = 0;
		int maxLen = 0;
		int N = S.length();
		Map<Character, Integer> map = new HashMap<>();
		int sum = 0;
		while (j < N) {
			int count = 0;
			if (map.containsKey(S.charAt(j))) {
				count = map.get(S.charAt(j));
				sum += count;
			}
			count++;
			sum++;
			map.put(S.charAt(j), count);
			if (map.size() == K) {
				if (sum > maxLen) {
					maxLen = j - i + 1;
				}
				j++;
			} else if (map.size() < K) {
				j++;
			} else {
				while (map.size() > K) {
					count = 0;
					if (map.containsKey(S.charAt(i))) {
						count = map.get(S.charAt(i));
					}
					count--;
					sum -= 1;
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
