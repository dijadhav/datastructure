package algorithm.search;

public class SearchOnDecendingSortedArray {

	public static void main(String[] args) {
		int arr[] = { 8, 7, 6, 5, 4, 3, 2, 1 };
		int num = 6;
		int low = 0;
		int index = -1;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == num) {
				index = mid;
				break;
			} else if (arr[mid] < num) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		System.out.println("Index of number is:" + index);
	}

}
