package algorithm.search;

public class IntegerSquareRoot {

	public static void main(String[] args) {
		System.out.println(sqrt(5));
	}

	public static int sqrt(int A) {
		if (A == 0 || A == 1)
			return A;
		int result = 1;
		int low = 1;
		int high = A;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (mid * mid == A)
				return mid;
			if (mid * mid < A) {
				low = mid +1;
				result = mid;
			} else
				high = mid - 1;
		}

		return result;
	}
}
