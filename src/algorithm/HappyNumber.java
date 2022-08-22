package algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class HappyNumber {
	public static void main(String[] args) {
		System.out.println(isHappy1(19));
		System.out.println(isHappy1(2));
		System.out.println(isHappy(19));
		System.out.println(isHappy(2));


	}

	public static boolean isHappy(int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(n);
		while (!queue.isEmpty()) {
			int num = queue.poll();
			if (num == 1)
				return true;
			if (num == 89)
				return false;

			int sq = 0;
			while (num != 0) {
				int rem = num % 10;
				sq += rem * rem;
				num = num / 10;
			}
			queue.offer(sq);
		}
		return false;
	}

	public static boolean isHappy1(int n) {
		if (n == 1)
			return true;
		if (n == 89)
			return false;

		int sq = 0;
		while (n != 0) {
			int rem = n % 10;
			sq += rem * rem;
			n = n / 10;
		}
		return isHappy1(sq);
	}
}
