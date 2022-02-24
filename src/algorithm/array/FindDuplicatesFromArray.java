package algorithm.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FindDuplicatesFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ArrayList<Integer> duplicates(int arr[], int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int count = 0;
			if (map.containsKey(arr[i])) {
				count = map.get(arr[i]);
			}
			count++;
			map.put(arr[i], count);
		}
		for (int key : map.keySet()) {
			if (map.get(key) > 1) {
				list.add(key);
			}
		}
		if (list.isEmpty())
			list.add(-1);
		Collections.sort(list);
		return list;
	}

}
