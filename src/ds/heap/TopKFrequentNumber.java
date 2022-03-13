package ds.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequentNumber {
	public static void main(String[] args) {

		int[] arr = { 1, 1, 1, 3, 2, 2, 4 };
		int[] topKElements = findTopKFrequentElements(arr, arr.length, 2);
		for (int i = 0; i < topKElements.length; i++) {
			System.out.print(topKElements[i] + " ");
		}

	}

	private static int[] findTopKFrequentElements(int[] arr, int n, int k) {
		PriorityQueue<Pair> pqueue = new PriorityQueue<Pair>(k, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.freq != o2.freq)
					return o2.freq - o1.freq;
				else
					return Integer.compare(o2.num, o1.num);
			}
		});
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			pqueue.offer(new Pair(entry.getKey(), entry.getValue()));
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
		int num;
		int freq;

		/**
		 * @param num
		 * @param freq
		 */
		public Pair(int num, int freq) {
			this.num = num;
			this.freq = freq;
		}

		@Override
		public String toString() {
			return num + ", " + freq;
		}

	}
}
