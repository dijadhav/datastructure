package ds.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SumofElementsBetweenk1andk2Smallest {

	public static void main(String[] args) {
		int arr[] = { 20, 8, 22, 4, 12, 10, 14 };
		int start = findKthSmallestElement(arr, arr.length, 3);
		int end = findKthSmallestElement(arr, arr.length, 6);
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > start && arr[i] < end) {
				sum += arr[i];
			}
		}
		System.out.println(sum);
	}

	private static int findKthSmallestElement(int[] arr, int length, int k) {
		PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o1);
			}
		});
		for (int i = 0; i < arr.length; i++) {
			pqueue.add(arr[i]);
			if (pqueue.size() > k) {
				pqueue.poll();
			}
		}

		return pqueue.peek();
	}

}
