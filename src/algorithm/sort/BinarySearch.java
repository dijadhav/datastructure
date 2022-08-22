package algorithm.sort;

/**
 * This code is implementation of the recursive algorithm.
 * 
 * @author dijadhav
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int index = binarySearch(arr, 0, 0, arr.length - 1);
		System.out.println(index);
	}

	/**
	 * Recursive implementation of the binary search
	 * 
	 * @param arr
	 * @param num
	 * @param low
	 * @param high
	 * @return
	 */
	private static int binarySearch(int[] arr, int num, int low, int high) {
		if (arr == null || arr.length == 0 || (arr.length == 1 && arr[0] != num) || high < low)
			return -1;
		int mid = low + (high - low) / 2;
		if (arr[mid] == num)
			return mid;
		if (arr[mid] > num) {
			return binarySearch(arr, num, low, mid - 1);
		}
		return binarySearch(arr, num, mid + 1, high);
	}
}
