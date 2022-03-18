package algorithm.search;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

	private LinkedHashMap<Integer, Integer> cache;

	public Solution(int capacity) {
		cache = new LinkedHashMap<Integer, Integer>(capacity) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
				return size() > capacity;
			}
		};
	}

	public int get(int key) {
		if (cache.containsKey(key))
			return cache.get(key);
		return -1;
	}

	public void set(int key, int value) {
		cache.put(key, value);
	}

	public static void main(String[] args) {
		Solution solution = new Solution(2);
		solution.set(1, 10);
		solution.set(5, 12);
		System.out.println(solution.get(5));
		System.out.println(solution.get(1));
		System.out.println(solution.get(10));
		solution.set(6, 14);
		System.out.println(solution.get(5));
	}
}
