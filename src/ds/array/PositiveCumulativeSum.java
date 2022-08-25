package ds.array;

import java.util.ArrayList;
import java.util.List;

public class PositiveCumulativeSum {

	public static void main(String[] args) {
		int[] arr = { 1, -1, -1, -1, 1 };
		List<Integer> list=getPositiveCumulativeSum(arr);
		list.stream().forEach(x->System.out.print(x+" "));
	}

	static List<Integer> getPositiveCumulativeSum(int[] arr) {
		int prev = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			int num = prev + arr[i];
			prev = num;
			list.add(num);
		}
		return list;
	}

}
