package algorithm;

import java.util.Scanner;

/**
 * Find the pyhagorean triplets
 * 
 * @author dijadhav
 *
 */
public class PythagoreanTriplets {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			//Find maximum number first
			int max = Math.max(a, Math.max(c, b));
			if (max == a) {
				if (isPythagoreanTriplet(b, c, a)) {
					System.out.println("Pythagorean triplets " + b + "," + c + "," + a);
				} else {
					System.out.println("This is not pythagorean triplets");
				}
			} else if (max == b) {
				if (isPythagoreanTriplet(a, c, b)) {
					System.out.println("Pythagorean triplets " + a + "," + c + "," + b);
				} else {
					System.out.println("This is not pythagorean triplets");
				}
			} else {
				if (isPythagoreanTriplet(a, b, c)) {
					System.out.println("Pythagorean triplets " + a + "," + b + "," + c);
				} else {
					System.out.println("This is not pythagorean triplets");
				}
			}

		}
	}

	/**
	 * Check given three number forms pythagorean triplets
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	private static boolean isPythagoreanTriplet(int a, int b, int c) {
		return (a * a + b * b) == c * c;
	}
}
