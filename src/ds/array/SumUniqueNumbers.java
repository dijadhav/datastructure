package ds.array;

public class SumUniqueNumbers {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 2 };
		System.out.println(sumOfUnique(arr));
	}

	public static int sumOfUnique(int[] nums) {
		if (null == nums || nums.length == 0) {
			return 0;
		}
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			boolean found = false;
			for (int j = 0; j < nums.length; j++) {
				if (i!=j && nums[i] == nums[j]) {
					found = true;
					break;
				}
			}
			if (!found) {
				sum += nums[i];
			}
		}
		return sum;
	}
}
