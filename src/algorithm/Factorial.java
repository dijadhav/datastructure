package algorithm;

public class Factorial {

	public static void main(String[] args) {
		System.out.println(factorialIterative(5));
		System.out.println(factorialRecurssion(5));

	}

	private static int factorialIterative(int num) {
		if (num <= 1) {
			return 1;
		}
		if (num == 2) {
			return 2;
		}
		int ans = 1;
		for (int i = 2; i <= num; i++) {
			ans *= i;
		}
		return ans;
	}

	private static int factorialRecurssion(int num) {
		if (num <= 1) {
			return 1;
		}
		if (num == 2) {
			return 2;
		}
		return num * factorialRecurssion(num - 1);
	}

}
