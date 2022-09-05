package algorithm;

import java.util.Scanner;

public class CandiesDistribution {
	public static void main(String args[]) {
		try (Scanner sc = new Scanner(System.in)) {
			int t = sc.nextInt();
			for (int i = 0; i < t; i++) {
				int N = sc.nextInt();
				int M = sc.nextInt();
				int candies = 0;
				for (int j = 0; j < N; j++) {
					candies += sc.nextInt();
				}
				System.out.println("Case #" + (i + 1) + ": " + (candies % M));
			}
		}
	}
}
