package ds.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SortKSortedArray {
	public static void main(String[] args) {
		int arr[] = { 6, 5, 3, 2, 8, 10, 9 };
		int k = 3;
		PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		});
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			pqueue.add(arr[i]);
			if (pqueue.size() > k) {
				arr[j] = pqueue.poll();
				j++;
			}
		}
		while (!pqueue.isEmpty()) {
			arr[j++] = pqueue.poll();
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
