package algorithm;

import java.util.Scanner;

/**
 * Check number is prime or not. The number is prime if it is divisible by 1 and
 * itself only.
 * 
 * @author dijadhav
 *
 */
public class CheckPrimeNumber {
	/**
	 * Main method of the application.
	 * 
	 * @param args - Array of command line arguments
	 */
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			System.out.println("Number is prime?:" + isPrime(n));
		}
	}

	/**
	 * Check given number is prime or not.
	 * 
	 * @param n
	 * @return
	 */
	private static boolean isPrime(int n) {
		if (n < 1)
			return false;
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
