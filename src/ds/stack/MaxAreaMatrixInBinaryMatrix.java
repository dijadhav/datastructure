package ds.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxAreaMatrixInBinaryMatrix {

	public static void main(String[] args) {
		char[][] arr = new char[][] { { '0', '1'},{'1', '0' } };
		List<Integer> list = new ArrayList<Integer>();
		for (int j = 0; j < arr[0].length; j++) {
			list.add(Character.getNumericValue(arr[0][j]));
		}

		int[] temp = new int[list.size()];

		for (int i = 0; i < temp.length; i++) {
			temp[i] = list.get(i);
		}
		int max = calculateMaximumAreaOfHistrogram(temp);
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				int k=Character.getNumericValue(arr[i][j]);
				if (k== 0) {
					temp[j] = 0;
				} else {
					temp[j] = temp[j] + k;
				}
			}
			max = Math.max(max, calculateMaximumAreaOfHistrogram(temp));
		}
		System.out.println(max);
	}

	private static int calculateMaximumAreaOfHistrogram(int[] temp) {
		int max = 0;
		int right[] = nextSmallerElementRight(temp, temp.length);
		int left[] = nextSmallerElementLeft(temp, temp.length);

		for (int i = 0; i < left.length; i++) {
			int sum = right[i] - left[i] - 1;
			if (sum * temp[i] > max) {
				max = sum * temp[i];
			}
		}
		return max;
	}

	private static int[] nextSmallerElementRight(int[] arr, int n) {
		if (null == arr || arr.length == 0 || n <= 0) {
			return new int[0];
		}
		Stack<int[]> stack = new Stack<>();
		int[] arr1 = new int[n];
		int k = n - 1;
		int pseudoIndex = arr.length;
		for (int i = n - 1; i >= 0; i--) {
			int[] pair = new int[2];
			int next = arr[i];
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

	private static int[] nextSmallerElementLeft(int[] arr, int n) {
		if (null == arr || arr.length == 0 || n <= 0) {
			return new int[0];
		}
		Stack<int[]> stack = new Stack<>();
		int[] arr1 = new int[n];
		int k = 0;
		int pseudoIndex = -1;
		for (int i = 0; i < n; i++) {
			int[] pair = new int[2];
			int next = arr[i];
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
