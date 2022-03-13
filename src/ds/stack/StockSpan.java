package ds.stack;

import java.util.Stack;

public class StockSpan {

	public static void main(String[] args) {
		int arr[] = new int[] { 100, 80, 60, 70, 60, 75, 85 };
		int arr1[] = bruteforce(arr);
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		arr = new int[] { 100, 80, 60, 70, 60, 75, 85 };
		arr1 = usingstack(arr, arr.length);
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
	}

	private static int[] usingstack(int[] price, int n) {
		if (null == price || price.length == 0 || n <= 0) {
			return new int[0];
		}
		Stack<int[]> stack = new Stack<>();
		int[] arr1 = new int[n];
		int k = 0;
		for (int i = 0; i < n; i++) {
			int[] pair = new int[2];
			int next = price[i];
			pair[0] = next;
			pair[1] = i;
			if (stack.isEmpty()) {
				arr1[k++] = -1;
			} else if (!stack.isEmpty() && stack.peek()[0] > next) {
				arr1[k++] = stack.peek()[1];
			} else if (!stack.isEmpty() && stack.peek()[0] <= next) {
				while (!stack.isEmpty() && stack.peek()[0] <= next) {
					stack.pop();
				}
				if (stack.isEmpty()) {
					arr1[k++] = -1;
				} else {
					arr1[k++] = stack.peek()[1];
				}
			}
			stack.push(pair);
		}
		for (int i = 0; i < n; i++) {
			arr1[i] = i - arr1[i];
		}
		return arr1;
	}

	private static int[] bruteforce(int[] arr) {
		int arr1[] = new int[arr.length];
		int k = 0;
		for (int i = 0; i < arr.length; i++) {
			int count = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] <= arr[i]) {
					count++;
				} else {
					break;
				}
			}
			arr1[k++] = count;
		}
		return arr1;
	}
}
