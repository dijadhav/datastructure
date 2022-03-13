package ds.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {
	public static void main(String[] args) {
		int[] arr = { 7, 10, 4, 3, 20, 15 };
		System.out.println(findKthLargestElement(arr, arr.length, 3));
	}

	private static int findKthLargestElement(int[] arr, int length, int k) {
		PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
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
