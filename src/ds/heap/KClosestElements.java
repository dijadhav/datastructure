package ds.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestElements {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 10, 10, 10 };
		int[] findKthClosestElement = findKthClosestElement(arr, arr.length, 1, 9);
		for (int i = 0; i < findKthClosestElement.length; i++) {
			System.out.print(findKthClosestElement[i] + " ");
		}
	}

	private static int[] findKthClosestElement(int[] arr, int n, int k, int x) {
		PriorityQueue<Pair> pqueue = new PriorityQueue<Pair>(k, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.diff != o2.diff)
					return o1.diff - o2.diff;
				else
					return Integer.compare(o1.num, o2.num);
			}
		});
		for (int i = 0; i < arr.length; i++) {
			pqueue.offer(new Pair(Math.abs(x-arr[i]), arr[i]));
		}
		int j = 0;
		int ans[] = new int[k];
		while (!pqueue.isEmpty() && k-- != 0) {
			ans[j++] = pqueue.poll().num;
		}
		Arrays.sort(ans);
		return ans;
	}

	static class Pair {
		int diff;
		int num;

		/**
		 * @param diff
		 * @param num
		 */
		public Pair(int diff, int num) {
			this.diff = diff;
			this.num = num;
		}

		@Override
		public String toString() {
			return diff + "," + num;
		}

	}
}
