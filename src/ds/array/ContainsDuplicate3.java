package ds.array;

public class ContainsDuplicate3 {

	public static void main(String[] args) {
		System.out.println(containsNearbyAlmostDuplicate(new int[] {-2147483648,2147483647}, 1, 1));
	}

	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				long diff=((long)nums[i] - (long)nums[j]);
				if (i != j && Math.abs(diff) <= t && Math.abs(i - j) <= k) {
					return true;
				}
			}
		}
		return false;
	}

}
