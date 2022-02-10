package algorithm.sort;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		int arr[] = new int[] { 6, 5, 3, 1, 8, 7, 2, 4 };
		for (int i = 0; i < arr.length; i++) {
			int min = arr[i];
			int minIndex = i;
			int j = i + 1;
			for (; j < arr.length; j++) {
				if (arr[j] < min) {
					min = arr[j];
					minIndex = j;
				}
			}
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
		Arrays.stream(arr).forEach(x -> {
			System.out.print(x + " ");
		});
	}
}
