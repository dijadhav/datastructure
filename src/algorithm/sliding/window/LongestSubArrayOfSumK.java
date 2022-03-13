package algorithm.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayOfSumK {

	public static void main(String[] args) {
		int[] arr = { 4, 1, 1, 1, 2, 3, 5 };
		int k = 5;
		System.out.println(lenOfLonestSubArrSlidingWindow(arr, arr.length, k));
		arr = new int[] { -13, 0, 6, 15, 16, 2, 15, -12, 17, -16, 0, -3, 19, -3, 2, -9, -6 };
		k = 15;

		System.out.println(lenOfLongSubarr(arr, arr.length, k));
	}

	private static int lenOfLonestSubArrSlidingWindow(int A[], int N, int K) {
		int i = 0;
		int j = 0;
		int maxLen = 0;
		int sum = 0;
		while (j < N && i < N) {
			sum += A[j];
			if (sum == K) {
				if (j - i + 1 > maxLen) {
					maxLen = j - i + 1;
					j++;
				}
			} else if (sum < K) {
				j++;
			} else {
				while (sum > K) {
					sum -= A[i];
					i++;
				}
				j++;

			}
		}
		return maxLen;
	}

	// Function for finding maximum and value pair
	public static int lenOfLongSubarr(int A[], int N, int K) {
		int maxLen = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 0);
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += A[i];
			if (sum == K) {
				maxLen = Math.max(maxLen, i + 1);
			}
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
			if (map.containsKey(sum - K)) {
				maxLen = Math.max(maxLen, i - map.get(sum - K));
			}

		}

		return maxLen;

	}
}
