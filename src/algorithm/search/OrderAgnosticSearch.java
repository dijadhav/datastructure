package algorithm.search;

public class OrderAgnosticSearch {

	public static void main(String[] args) {
		int arr[] = { 8, 7, 6, 5, 4, 3, 2, 1 };
		
		int num = 6;
		if (arr.length == 1 && arr[0] == num) {
			System.out.println(num + " found at index 0");
			return;
		}
		boolean ascending = false;
		if (arr[0] < arr[1])
			ascending = true;
		int low = 0;
		int index = -1;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == num) {
				index = mid;
				break;
			}

			if (arr[mid] < num) {
				if (ascending) {
					low = mid + 1;
				} else
					high = mid - 1;
			} else {
				if (ascending) {
					high = mid - 1;
				} else
					low = mid + 1;
			}
		}
		System.out.println("Index of number is:" + index);

	}

}
