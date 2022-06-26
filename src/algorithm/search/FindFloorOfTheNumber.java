package algorithm.search;

public class FindFloorOfTheNumber {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 8, 9, 10, 11 };
		int num = 5;
		System.out.println("Floor of " + num + " is:" + findFloor(arr, arr.length, num));
		System.out.println("Ceil of " + num + " is:" + findCeil(arr, arr.length, num));
	}

	private static int findFloor(int[] arr, int n, int num) {
		int l = 0;
		int r = arr.length - 1;
		int floor = -1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == num) {
				floor = arr[mid];
				break;
			} else if (arr[mid] > num) {
				r = mid - 1;
			} else if (arr[mid] < num) {
				floor = arr[mid];
				l = mid + 1;
			}
		}
		return floor;
	}

	private static int findCeil(int[] arr, int n, int num) {
		int l = 0;
		int r = arr.length - 1;
		int floor = -1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == num) {
				floor = arr[mid];
				break;
			} else if (arr[mid] > num) {
				floor = arr[mid];
				r = mid - 1;
			} else if (arr[mid] < num) {
				l = mid + 1;
			}
		}
		return floor;
	}

}
