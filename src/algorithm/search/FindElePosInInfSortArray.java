package algorithm.search;

public class FindElePosInInfSortArray {

	public static void main(String[] args) {
		int arr[] = new int[] { 3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170 };
		int num = 100;
		System.out.println("Postion of 10 in infinite array is:" + findPosition(arr, arr.length, num));
	}

	private static int findPosition(int[] arr, int n, int num) {
		int l = 0;
		int r = 1;
		int pos = -1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == num)
				return mid;
			else if (arr[mid] < num) {
				l = r;
				r = r * 2;
			} else {
				r = mid - 1;
			}
		}
		return pos;
	}

}
