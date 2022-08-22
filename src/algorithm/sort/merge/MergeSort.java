package algorithm.sort.merge;

import java.util.Arrays;

/**
 * Notes: The code is written for the merge sort algorithm. This algorithm is
 * based on divide and conquer technique. Array is repeatedly
 * https://www.geeksforgeeks.org/merge-sort/?ref=lbp
 * 
 * @author dijadhav
 *
 */
public class MergeSort {
	/**
	 * Main method of the application.
	 * 
	 * @param args - A-bootclasspathrray of the command line arguments
	 */
	public static void main(String[] args) {
		int arr[] = new int[] { 6, 5, 3, 1, 8, 7, 2, 4 };
		mergeSort(arr, 0, arr.length - 1);
		Arrays.stream(arr).forEach(x -> {
			System.out.print(x + " ");
		});

	}

	/**
	 * Merge sort
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 */
	private static void mergeSort(int[] arr, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}

	}

	private static void merge(int[] arr, int low, int mid, int high) {
		int s1 = mid - low + 1;
		int s2 = high - mid;
		int[] left = new int[s1];
		int[] right = new int[s2];
		for (int i = 0; i < s1; i++) {
			left[i] = arr[i + low];
		}

		for (int i = 0; i < s2; i++) {
			right[i] = arr[i + mid + 1];
		}
		int i = 0, j = 0, k = low;

		while (i < s1 && j < s2) {
			if (left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < s1) {
			arr[k] = left[i];
			i++;
			k++;
		}
		while (j < s2) {
			arr[k] = right[j];
			j++;
			k++;
		}
	}

}
