package algorithm.sliding.window;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MaximumOfAllSubArray {

	public static void main(String[] args) {
		int arr[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		ArrayList<Integer> list = solve(arr, arr.length, 1);
		for (int i : list) {
			System.out.print(i + " ");
		}
	}

	private static ArrayList<Integer> solve(int[] arr, int n, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Deque<Integer> queue = new LinkedList<Integer>();
		int i = 0, j = 0;

		while (j < n) {
			while (!queue.isEmpty() && queue.peekLast() < arr[j]) {
				queue.pollLast();
			}
			queue.offer(arr[j]);
			if (j - i + 1 < k) {
				j++;
			} else {
				if ((j - i + 1) == k) {
					if (!queue.isEmpty())
						list.add(queue.peek());
					
					if (arr[i] == queue.peek())
						queue.poll();
					i++;
					j++;
				}

			}

		}
		return list;
	}

}
