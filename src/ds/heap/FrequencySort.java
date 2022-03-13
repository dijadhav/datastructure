package ds.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class FrequencySort {
	public static void main(String[] args) {

		int[] arr = { 1, 1, 1, 3, 2, 2, 4 };
		int[] topKElements = frequencySort(arr);
		for (int i = 0; i < topKElements.length; i++) {
			System.out.print(topKElements[i] + " ");
		}
	}

	private static int[] frequencySort(int[] arr) {
		PriorityQueue<Pair> pqueue = new PriorityQueue<Pair>(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return Integer.compare(o1.freq, o2.freq);
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
		int ans[] = new int[arr.length];
		while (!pqueue.isEmpty()) {
			Pair pair = pqueue.poll();
			for (int i = 0; i < pair.freq; i++) {
				ans[j++] = pair.num;
			}

		}
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
