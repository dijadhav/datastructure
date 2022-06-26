package algorithm.search;

public class FindMaxInBitonicArray {

	public static void main(String[] args) {
		int arr[] = { 10, 20, 45, 67, 6, 3, 2, 1 };
		int pos = search(arr, 0, arr.length - 1);
		if (pos != -1) {
			System.out.println("Maximum element in bitonic array:" + arr[pos]);
		}
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
