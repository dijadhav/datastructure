package algorithm.dp.lcs;

/**
 * This class solves the LIS problem using brute-force algorithm
 * 
 * @author dijadhav
 *
 */
public class LongestIncreasingSubSequence {
	private static int arr[][];

	/**
	 * Main method of the application
	 * 
	 * @param args - Array of the command line arguments
	 */
	public static void main(String[] args) {
		System.out.println(
				"Longest Increasing sub-sequence:" + lisBruteForce(new int[] { 10, 22, 9, 33, 21, 50, 41, 60, 80 }));
		System.out.println("Longest Increasing sub-sequence:" + lisBruteForce(new int[] { 3, 10, 2, 1, 20 }));
		System.out.println("Longest Increasing sub-sequence:" + lisBruteForce(new int[] { 3, 2 }));
		System.out.println("Longest Increasing sub-sequence:" + lisBruteForce(new int[] { 50, 3, 10, 7, 40, 80 }));

		System.out.println("Longest Increasing sub-sequence Recursive:"
				+ lisRecurssive(new int[] { 10, 22, 9, 33, 21, 50, 41, 60, 80 }, 0, 0));

		System.out.println(
				"Longest Increasing sub-sequence Recursive:" + lisRecurssive(new int[] { 3, 10, 2, 1, 20 }, 0, 0));
		System.out.println("Longest Increasing sub-sequence Recursive:" + lisRecurssive(new int[] { 3, 2 }, 0, 0));
		System.out.println(
				"Longest Increasing sub-sequence Recursive:" + lisRecurssive(new int[] { 50, 3, 10, 7, 40, 80 }, 0, 0));

		int nums[] = new int[] { 50, 3, 10, 7, 40, 80 };
		arr = new int[nums.length + 1][nums.length + 1];
	}

	/**
	 * Find the LIS length using brute force algorithm
	 * 
	 * @param arr - Integer array
	 * @return LIS length
	 */
	private static int lisBruteForce(int[] arr) {
		int len = 0;
		for (int i = 0; i < arr.length; i++) {
			int l = 1;
			for (int j = i; j < arr.length - 1; j++) {
				if (arr[j] < arr[j + 1]) {
					l++;
				}
			}
			if (l > len)
				len = l;
		}
		return len;
	}

	/**
	 * Find the LIS length using recursive algorithm
	 * 
	 * @param arr - Integer array
	 * @return LIS length
	 */
	private static int lisRecurssive(int[] arr, int n, int len) {

		if (arr.length == n)
			return len;
		int l = 1;
		for (int i = n; i < arr.length - 1; i++) {
			int j = i;
			if (arr[j] < arr[j + 1]) {
				l++;
			}
		}
		if (l > len)
			len = l;

		return lisRecurssive(arr, n + 1, len);
	}
}
