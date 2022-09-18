package algorithm;

import java.util.Scanner;

/**
 * Reverse the given number
 * 
 * @author dijadhav
 *
 */
public class ReverseNumber {
	/**
	 * Main method of the application
	 * 
	 * @param args - Array of command line arguments
	 */
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			System.out.println(reverse(n));
		}
	}

	/**
	 * Reverse the number
	 * 
	 * @param n
	 * @return
	 */
	private static int reverse(int n) {
		int num = 0;
		while (n != 0) {
			int rem = n % 10;
			num = num * 10 + rem;
			n = n / 10;
		}
		return num;
	}
}
