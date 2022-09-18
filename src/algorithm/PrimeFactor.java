package algorithm;

import java.util.Scanner;

/**
 * Find the factor of the number
 * 
 * @author dijadhav
 *
 */
public class PrimeFactor {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int num = sc.nextInt();
			bruteforce(num);
			solve(num);
		}
	}

	/**
	 * Find the prime factors of the given number.
	 * 
	 * @param num
	 */
	private static void solve(int num) {
		int n = num;
		for (int i = 2; i * i <= n; i++) {
			while (n % i == 0) {
				n /= i;
				System.out.print(i + " ");
			}
		}
		if (n != 1) {
			System.out.println(n);
		}
	}

	private static void bruteforce(int num) {
		/**
		 * Find the prime factors of the given number
		 */
		for (int i = 2; i <= num; i++) {
			if (num % i == 0 && isPrime(i)) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	/**
	 * Check number is price or not
	 * 
	 * @param num
	 * @return
	 */
	private static boolean isPrime(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

}
