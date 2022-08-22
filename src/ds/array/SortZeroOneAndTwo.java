package ds.array;

import java.util.Arrays;

public class SortZeroOneAndTwo {

	public static void main(String[] args) {

		int arr[] = { 0, 2, 1, 2, 0 };
		arr = sort(arr, arr.length);
		Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
	}

	private static int[] sort(int[] arr, int n) {
		int zeros = 0;
		int ones = 0;
		int twos = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0)
				zeros++;
			if (arr[i] == 1)
				ones++;
			if (arr[i] == 2)
				twos++;
		}
		int i = 0;
		for (; i < zeros; i++) {
			arr[i] = 0;
		}
		for (; i < zeros + ones; i++) {
			arr[i] = 1;
		}
		for (; i < zeros + ones + twos; i++) {
			arr[i] = 2;
		}
		return arr;
	}

}
