package algorithm.search;

public class NumberOfTimesSortedArrayRotated {

	public static void main(String[] args) {

		int arr[] = { 11, 12, 15, 18, 2, 5, 6, 8 };
		int min = arr[0];
		int rotations = 0;
		int l = 0;
		int r = arr.length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] < min) {
				min = arr[mid];
				rotations = mid;
				r = mid - 1;
			} else if (arr[mid] > min) {
				l = mid + 1;
			}
		}
		System.out.println(rotations);
	}

}
