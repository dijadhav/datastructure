package algorithm.sort;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int arr[] = new int[] { 6, 5, 3, 1, 8, 7, 2, 4 };
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		Arrays.stream(arr).forEach(x -> {
			System.out.print(x + " ");
		});

	}
}
