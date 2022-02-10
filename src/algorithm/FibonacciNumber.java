package algorithm;

public class FibonacciNumber {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(fibonnacciNumberIterative(8));
		System.out.println(fibonnacciNumberRecursive(8));

	}

	private static int fibonnacciNumberIterative(int num) {
		if (num < 2) {
			return num;
		}
		int f0 = 0;
		int f1 = 1;
		int ans = f0 + f1;
		int arr[] = new int[num + 1];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i <= num; i++) {
			ans = arr[i - 1] + arr[i - 2];
			arr[i] = ans;
		}
		return ans;
	}

	private static int fibonnacciNumberRecursive(int num) {
		if (num < 2) {
			return num;
		}
		return fibonnacciNumberRecursive(num - 1) + fibonnacciNumberRecursive(num - 2);
	}
}
