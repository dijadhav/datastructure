package algorithm.sort;

import java.util.Arrays;

/**
 * 
 * 
 * Time complexity is O(n)2
 * 
 * @author dijadhav
 *
 */
public class SelectionSort {
	public static void main(String[] args) {
		int arr[] = new int[] { 6, 5, 3, 1, 8, 7, 2, 4 };
		selectionSort(arr);
		Arrays.stream(arr).forEach(x -> {
			System.out.print(x + " ");
		});
	}

	/**
	 * Sort the array using selection sort
	 * 
	 * @param arr
	 */
	private static void selectionSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			if (min != i) {
				int temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
	}
}
