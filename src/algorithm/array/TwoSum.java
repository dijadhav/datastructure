package algorithm.array;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	public static void main(String[] args) {
		TwoSum obj = new TwoSum();
		int [] arr= {2,7,11,15};
		int target = 9;
		int []res=obj.twoSum(arr, target);
		Arrays.stream(res).forEach(x->System.out.print(x+" "));
	}

	public int[] twoSum(int[] nums, int target) {
		int n = nums.length;
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (map.containsKey(target - nums[i])) {
				result[0] = map.get(target - nums[i]);
				result[1] = i;
				break;
			} else {
				map.put(nums[i], i);
			}
		}
		return result;
	}
}
