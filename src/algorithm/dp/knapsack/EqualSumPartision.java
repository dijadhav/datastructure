package algorithm.dp.knapsack;

public class EqualSumPartision {

	public static void main(String[] args) {
		int arr[] = { 0, 3, 8, 9, 2 };
		System.out.println(subsetSum(arr, 0));
	}

	private static boolean subsetSum(int[] arr, int sum) {
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		if (sum % 2 != 0) {
			return false;
		}
		return hasSubsetSumRecursive(arr, sum / 2, arr.length - 1);
	}
	private static boolean hasSubsetSumRecursive(int[] arr, int sum, int n) {
		if (n == 0 && sum == 0)
			return true;
		if (n == 0 && sum != 0)
			return false;
		if (n != 0 && sum == 0)
			return true;

		if (arr[n] <= sum) {
			return hasSubsetSumRecursive(arr, sum - arr[n], n - 1) || hasSubsetSumRecursive(arr, sum, n - 1);
		}
		return hasSubsetSumRecursive(arr, sum, n - 1);
	}

}
