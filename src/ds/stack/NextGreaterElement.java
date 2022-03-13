package ds.stack;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		long arr[] = { 7, 8, 1, 4 };
		long[] arr1 = nextLargerElementBruteForce(arr, arr.length);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		arr = new long[] { 1, 3, 2, 4 };
		arr1 = nextLargerElementUsingStack(arr, arr.length);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr1[i] + " ");
		}
	}

	private static long[] nextLargerElementUsingStack(long[] arr, int n) {
		if (null == arr || arr.length == 0 || n <= 0) {
			return new long[0];
		}
		Stack<Long> stack = new Stack<>();
		long[] arr1 = new long[n];
		int k = n - 1;
		for (int i = n - 1; i >= 0; i--) {
			long next = arr[i];
			if (stack.isEmpty()) {
				stack.push(next);
				arr1[k--] = -1;
			} else {
				while (!stack.isEmpty() && stack.peek() < next) {
					stack.pop();
				}
				if (!stack.isEmpty() && stack.peek() > next) {
					arr1[k--] = stack.peek();
					stack.push(next);
				}
				if (stack.isEmpty()) {
					arr1[k--] = -1;
					stack.push(next);
				}
			}
		}

		return arr1;
	}

	public static long[] nextLargerElementBruteForce(long[] arr, int n) {
		if (null == arr || arr.length == 0 || n <= 0) {
			return new long[0];
		}
		long[] arr1 = new long[n];
		int k = 0;
		for (int i = 0; i < n; i++) {
			long greater = -1;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] > arr[i]) {
					greater = arr[j];
					break;
				}
			}
			arr1[k++] = greater;
		}
		return arr1;
	}
}
