package algorithm.search;

public class PeakElement {

	public static void main(String[] args) {
		int arr[] = { 5, 10, 20, 15 };
		System.out.println(search(arr, 0, arr.length - 1));
	}

	private static int search(int[] arr, int l, int r) {
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (mid < 0 || mid >= arr.length)
				return -1;
			if (mid > 0 && mid < arr.length - 1) {
				if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
					return mid;
				} else if (arr[mid + 1] > arr[mid]) {
					l = mid + 1;
				} else if (arr[mid - 1] > arr[mid]) {
					r = mid - 1;
				}
			} else if (mid == 0) {
				if (arr[mid + 1] < arr[mid])
					return mid;
				else
					return 1;
			} else if (mid == arr.length - 1) {
				if (arr[mid] > arr[mid - 1])
					return mid;
				else
					return mid - 1;
			}

		}
		return -1;
	}

}
