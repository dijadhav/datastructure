package algorithm.search;

public class MinDifffEle {

	public static void main(String[] args) {
		int arr[] = { 1,6,10 };
		int num = 7;
		int pos = -1;
		int l = 0;
		int r = arr.length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == num) {
				pos = mid;
				break;
			} else if (arr[mid] < num) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		if (pos != -1) {
			System.out.println("Mininum difference element is:" + num);
		} else {
			int floor = arr[r];
			int ceil = arr[l];
			if (Math.abs(floor - num) <= Math.abs(ceil - num)) {
				System.out.println("Mininum difference element is:" + floor);
			} else {
				System.out.println("Mininum difference element is:" + ceil);

			}
		
		}

	}
}
