package algorithm.search;

public class FindNextLetter {

	public static void main(String[] args) {
		char[] arr = { 'a', 'c', 'f', 'h' };
		char ch = 'c';
		int n = arr.length;
		int l = 0;
		int r = n - 1;
		char res = '\0';
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] <= ch) {
				l = mid + 1;
			} else if (arr[mid] > ch) {
				res = arr[mid];
				r = mid - 1;
			}
		}

		System.out.println("Next letter is:" + res);
	}

}
