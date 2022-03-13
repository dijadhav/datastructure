package algorithm.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class PickToy {

	public static void main(String[] args) {
		System.out.println(lenOfLongSubarr("abaccab", 2));
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
