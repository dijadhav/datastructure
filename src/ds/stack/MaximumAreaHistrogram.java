package ds.stack;

import java.util.Stack;

public class MaximumAreaHistrogram {
	public static void main(String[] args) {
		long arr[] = { 1, 2, 3, 4, 5 };
		long right[] = nextSmallerElementRight(arr, arr.length);
		long left[] = nextSmallerElementLeft(arr, arr.length);
		long max = 0;
		for (int i = 0; i < left.length; i++) {
			long sum = right[i] - left[i] - 1;
			if (sum * arr[i] > max) {
				max = sum * arr[i];
			}
		}
		System.out.println(max);
	}

	private static long[] nextSmallerElementRight(long[] arr, int n) {
		if (null == arr || arr.length == 0 || n <= 0) {
			return new long[0];
		}
		Stack<long[]> stack = new Stack<>();
		long[] arr1 = new long[n];
		int k = n-1;
		int pseudoIndex = arr.length;
		for (int i = n - 1; i >= 0; i--) {
			long[] pair = new long[2];
			long next = arr[i];
			pair[0] = next;
			pair[1] = i;
			if (stack.isEmpty()) {
				arr1[k--] = pseudoIndex;
			} else if (!stack.isEmpty() && stack.peek()[0] < next) {
				arr1[k--] = stack.peek()[1];
			} else if (!stack.isEmpty() && stack.peek()[0] >= next) {
				while (!stack.isEmpty() && stack.peek()[0] >= next) {
					stack.pop();
				}
				if (stack.isEmpty()) {
					arr1[k--] = pseudoIndex;
				} else {
					arr1[k--] = stack.peek()[1];
				}
			}
			stack.push(pair);
		}
		return arr1;
	}

	private static long[] nextSmallerElementLeft(long[] arr, int n) {
		if (null == arr || arr.length == 0 || n <= 0) {
			return new long[0];
		}
		Stack<long[]> stack = new Stack<>();
		long[] arr1 = new long[n];
		int k = 0;
		int pseudoIndex = -1;
		for (int i = 0; i < n; i++) {
			long[] pair = new long[2];
			long next = arr[i];
			pair[0] = next;
			pair[1] = i;
			if (stack.isEmpty()) {
				arr1[k++] = pseudoIndex;
			} else if (!stack.isEmpty() && stack.peek()[0] < next) {
				arr1[k++] = stack.peek()[1];
			} else if (!stack.isEmpty() && stack.peek()[0] >= next) {
				while (!stack.isEmpty() && stack.peek()[0] >= next) {
					stack.pop();
				}
				if (stack.isEmpty()) {
					arr1[k++] = pseudoIndex;
				} else {
					arr1[k++] = stack.peek()[1];
				}
			}
			stack.push(pair);
		}
		return arr1;
	}
}
