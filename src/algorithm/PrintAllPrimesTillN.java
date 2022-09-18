package algorithm;

import java.util.Scanner;

/**
 * Print all prime numbers from 1 to n(both inclusive)
 * 
 * @author dijadhav
 *
 */
public class PrintAllPrimesTillN {
	/**
	 * Main method of the application
	 * 
	 * @param args - Array of command line arguments
	 */
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			printPrime(n, 1);
		}
	}

	/**
	 * Print the prime numbers from 1 to n.
	 * 
	 * @param n   - Highest range
	 * @param num - Number to be checked whether it is prime or not.
	 */
	private static void printPrime(int n, int num) {
		if (num <= n) {
			if (isPrime(num)) {
				System.out.print(num + " ");
			}
			printPrime(n, num + 1);
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
