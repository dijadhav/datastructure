package ds.array;

/**
 * Find the peak element in the array . Peak element is the element who is not
 * smaller than adjacent elements
 * 
 * @author dijadhav
 *
 */
public class PeakElement {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		System.out.println(peakElement(arr, arr.length));
	}

	/**
	 * Get the peak element
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	public static int peakElement(int[] arr, int n) {
		int peek = 0;
		for (int i = 1; i < n; i++) {
			if (arr[i] > arr[i - 1]) {
				peek = i;
			}
		}
		return peek;
	}
}
