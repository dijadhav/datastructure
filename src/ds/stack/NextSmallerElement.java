package ds.stack;

import java.util.Stack;

public class NextSmallerElement {

	public static void main(String[] args) {
		int arr[] = { 13, 7, 6, 12 };
		int[] arr1 = nextSmallerElementBruteForce(arr, arr.length);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		arr = new int[] { 2, 5, 3, 7, 1, 5, 2, 6, 3, 1 };
		arr1 = nextSmallerElementUsingStack(arr, arr.length);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr1[i] + " ");
		}
	}

	private static int[] nextSmallerElementUsingStack(int[] arr, int n) {
		if (null == arr || arr.length == 0 || n <= 0) {
			return new int[0];
		}
		Stack<Integer> stack = new Stack<>();
		int[] arr1 = new int[n];
		int k = n - 1;
		for (int i = n - 1; i >= 0; i--) {
			int next = arr[i];
			if (stack.isEmpty()) {
				stack.push(next);
				arr1[k--] = -1;
			} else {
				while (!stack.isEmpty() && stack.peek() >= next) {
					stack.pop();
				}
				if (!stack.isEmpty() && stack.peek() < next) {
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

	public static int[] nextSmallerElementBruteForce(int[] arr, int n) {
		if (null == arr || arr.length == 0 || n <= 0) {
			return new int[0];
		}
		int[] arr1 = new int[n];
		int k = 0;
		for (int i = 0; i < n; i++) {
			int smaller = -1;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[i]) {
					smaller = arr[j];
					break;
				}
			}
			arr1[k++] = smaller;
		}
		return arr1;
	}
}
