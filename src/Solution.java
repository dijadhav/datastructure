import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = Integer.valueOf(sc.nextLine());
		for (int i = 1; i <= t; i++) {
			int n = Integer.valueOf(sc.nextLine());
			String[] cards = new String[n];
			for (int j = 0; j < n; j++) {
				cards[j] = sc.nextLine();
			}
			int cost = 0;
			int prev = 0;
			for (int j = 1; j < n; j++) {
				if (cards[j].compareTo(cards[prev]) < 0) {
					cost++;
				}
			}
			System.out.print("Case #" + i + ":");
			System.out.println(cost);

		}
		sc.close();

	}
}