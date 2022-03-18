package algorithm.search;

public class FindFirstAndLastOccuranceOfElement {

	public static void main(String[] args) {
		int arr[] = { 5, 7, 7, 8, 8, 10 };
		int num = 8;
		int first = findFirstOccurance(arr, arr.length, num);
		int last = findLastOccurance(arr, arr.length, num);
		System.out.println(first + " " + last);
	}

	private static int findFirstOccurance(int[] arr, int length, int num) {
		int low = 0;
		int high = length - 1;
		int first = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == num) {
				first = mid;
				high = mid - 1;
			} else if (num < arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return first;
	}

	private static int findLastOccurance(int[] arr, int length, int num) {
		int low = 0;
		int high = length - 1;
		int last = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == num) {
				last = mid;
				low = mid + 1;
			} else if (num < arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return last;
	}

}
