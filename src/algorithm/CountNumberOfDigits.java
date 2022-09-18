package algorithm;

import java.util.Scanner;

/**
 * Count the number of digits in given number.
 * 
 * @author dijadhav
 *
 */
public class CountNumberOfDigits {
	/**
	 * Main method of the application
	 * 
	 * @param args - Array of command line arguments
	 */
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int cnt = 0;
			while (n != 0) {
				cnt++;
				n /= 10;
			}
			System.out.println("Number Digits?:" + cnt);
		}

	}

}
