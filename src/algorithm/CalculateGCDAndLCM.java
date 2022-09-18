package algorithm;

import java.util.Scanner;

/**
 * Calculate the gcd and lcd of the given number
 * 
 * @author dijadhav
 *
 */
public class CalculateGCDAndLCM {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();

			System.out.println("GCD of the given number:" + gcd(num1, num2));
			System.out.println("LCD of the given number:" + lcd(num1, num2));

		}
	}

	/**
	 * LCD(Least Common Denominator ) is the smallest number which is divisible by
	 * given two numbers
	 * 
	 * @param num1
	 * @param num2
	 * @return LCD of two numbers
	 */
	private static int lcd(int num1, int num2) {
		int gcd = gcd(num1, num2);
		return (num1 * num2) / gcd;
	}

	/**
	 * GCD (Greatest Common Divisor) is the greatest number which divides this two
	 * numbers
	 * 
	 * @param num1
	 * @param num2
	 * @return GCD of two numbers
	 */
	private static int gcd(int num1, int num2) {
		while (num1 % num2 != 0) {
			int rem = num1 % num2;
			if (rem == 0) {
				break;
			} else {
				num1 = num2;
				num2 = rem;
			}
		}
		return num2;

	}

}
