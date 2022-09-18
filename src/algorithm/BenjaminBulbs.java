package algorithm;

import java.util.Scanner;

/**
 * Find the number of bulbs remained on after n rounds.Perfect square are
 * remained on because perfect square have odd number of divisors.
 * 
 * @author dijadhav
 *
 */
public class BenjaminBulbs {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int cnt = 0;
			for (int r = 1; r * r <= n; r++) {
				cnt++;
			}
			System.out.println("Number of bulbs are on after " + n + " rounds:" + cnt);
		}
	}
}
