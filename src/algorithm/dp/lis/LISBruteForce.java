package algorithm.dp.lis;

/**
 * This class solves the LIS problem using brute-force algorithm
 * 
 * @author dijadhav
 *
 */
public class LISBruteForce {

	/**
	 * Main method of the application
	 * 
	 * @param args - Array of the command line arguments
	 */
	public static void main(String[] args) {
		System.out.println(
				"Longest Increasing sub-sequence:" + bruteForceLIS(new int[] { 10, 22, 9, 33, 21, 50, 41, 60, 80 }));
		System.out.println("Longest Increasing sub-sequence:" + bruteForceLIS(new int[] { 3, 10, 2, 1, 20 }));
		System.out.println("Longest Increasing sub-sequence:" + bruteForceLIS(new int[] { 3, 2 }));
		System.out.println("Longest Increasing sub-sequence:" + bruteForceLIS(new int[] { 50, 3, 10, 7, 40, 80 }));

	}

	/**
	 * Find the LIS length using brute force algorithm
	 * 
	 * @param arr - Integer array
	 * @return LIS length
	 */
	private static int bruteForceLIS(int[] arr) {
		int len = 0;
		for (int i = 0; i < arr.length; i++) {
			int l = 1;
			for (int j = 0;  j< arr.length-1; j++) {
				if (arr[j] < arr[j+1]) {
					l++;
				} 
			}
			if (l > len)
				len = l;
		}
		return len;
	}

}
