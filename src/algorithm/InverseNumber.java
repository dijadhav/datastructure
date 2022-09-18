package algorithm;

import java.util.Scanner;

/**
 * Inverse the number. Inverse of a number is formed by changing digit and its
 * place value.
 * 
 * @author dijadhav
 *
 */
public class InverseNumber {

	/**
	 * Main method of the application
	 * 
	 * @param args - Array of command line arguments
	 */
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			System.out.println(inverseNumber(n));
		}
	}

	/**
	 * Find the inverse of the given number
	 * 
	 * @param n
	 * @return
	 */
	private static int inverseNumber(int n) {
		int pos = 0;
		int inv = 0;
		while (n != 0) {
			int rem = n % 10;
			pos++;
			n /= 10;
			inv += pos * Math.pow(10, rem - 1);
		}
		return inv;
	}

}
