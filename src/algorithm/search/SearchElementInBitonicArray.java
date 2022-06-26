package algorithm.search;

public class SearchElementInBitonicArray {

	public static void main(String[] args) {
		int arr[] = { 10, 20, 45, 67, 6, 3, 2, 1 };
		int pos = findPeakElementIndex(arr, 0, arr.length - 1);
		if (pos != -1) {
			int left = search(arr, 20, 0, pos - 1);
			if (left == -1) {
				int right = searchInDecendingArray(arr, 6, pos, arr.length - 1);
				if (right != -1) {
					System.out.println("Element found in bitonic array at:" + right);
				} else {
					System.out.println("Element does not exist in bitonic array");
				}
			} else {
				System.out.println("Element found in bitonic array at:" + left);
			}
		} else {
			System.out.println("Element does not exist in bitonic array");
		}
	}

	private static int findPeakElementIndex(int[] arr, int l, int r) {
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

	private static int searchInDecendingArray(int arr[], int num, int low, int high) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == num) {
				return mid;
			} else if (arr[mid] < num) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	private static int search(int arr[], int num, int low, int high) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == num) {
				return mid;
			} else if (arr[mid] < num) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

}
