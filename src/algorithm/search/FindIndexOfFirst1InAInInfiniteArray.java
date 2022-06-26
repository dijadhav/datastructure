package algorithm.search;

public class FindIndexOfFirst1InAInInfiniteArray {

	public static void main(String[] args) {
		int arr[] = { 0, 0, 0, 0, 0, 1, 1, 1 };
		int num = 1;
		int first = findFirstOccurance(arr, arr.length, num);
		System.out.println(first);
	}

	private static int findFirstOccurance(int[] arr, int length, int num) {
		int low = 0;
		int high = 1;
		int first = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == num) {
				first = mid;
				high = mid - 1;
			} else if (num < arr[mid]) {
				high = mid - 1;
			} else {
				low = high;
				high = high * 2;
			}
		}
		return first;
	}
}
