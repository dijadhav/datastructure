package ds.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ConnectRopesWithMinimumCost {

	public static void main(String[] args) {
		long arr[] = { 1, 2, 3, 4, 5 };
		System.out.println(minCost(arr, arr.length));
	}

	static long minCost(long arr[], int n) {
		PriorityQueue<Long> pqueue = new PriorityQueue<Long>(new Comparator<Long>() {

			@Override
			public int compare(Long o1, Long o2) {
				return Long.compare(o1, o2);
			}
		});
		for (int i = 0; i < n; i++) {
			pqueue.offer(arr[i]);
		}
		long totalCost = 0;
		while (pqueue.size() != 1) {
			long num1 = pqueue.poll();
			long num2 = pqueue.poll();
			long cost = num1 + num2;
			totalCost += cost;
			pqueue.offer(cost);
		}
		return totalCost;
	}
}
