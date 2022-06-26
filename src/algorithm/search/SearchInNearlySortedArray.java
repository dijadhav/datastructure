package algorithm.search;

public class SearchInNearlySortedArray {

	public static void main(String[] args) {
		int arr[] = { 3, 2, 10, 4, 40 };
		int n = arr.length;
		int x = 4;
		System.out.println(search(arr, 0, n, x));

	}

	private static int search(int[] arr, int l, int r, int num) {
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (mid < 0 || mid >= arr.length)
				return -1;
			if (arr[mid] == num) {
				return mid;
			} else if (arr[mid - 1] == num) {
				return mid - 1;
			} else if (arr[mid + 1] == num) {
				return mid + 1;
			} else if (mid - 1 >= 0 && arr[mid - 1] > num) {
				r = mid - 2;
			} else if (mid + 1 <= arr.length && arr[mid + 1] < num) {
				l = mid + 2;
			}
		}
		return -1;
	}

}
