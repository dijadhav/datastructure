package algorithm.dp.lcs;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			int min = Integer.MAX_VALUE;
			String temp =sc.next();
			boolean possible = false;
			for (int j = 0; j < 9; j++) {
				for (int k = 1; k < temp.length(); k++) {
					String val = temp.substring(0, k) + "" + j + temp.substring(k);
					if (isDivBy9(val)) {
						min = Math.min(min, Integer.valueOf(val));
						possible = true;
					}
				}
				if (j != 0) {
					int val = Integer.valueOf(j + "" + temp);
					if (isDivBy9(val)) {
						min = Math.min(min, val);
						possible = true;
					}
				}
				int val = Integer.valueOf(temp + "" + j);
				if (isDivBy9(val)) {
					min = Math.min(min, val);
					possible = true;
				}
			}
			if (possible)
				System.out.println("Case #" + (i + 1) + ": " + min);
			else
				System.out.println("Case #" + (i + 1) + ": 0");
		}
		sc.close();
	}

	private static boolean isDivBy9(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean isDivBy9(int n) {

		if (n == 0 || n == 9)
			return true;
		if (n < 9)
			return false;
		return isDivBy9((int) (n >> 3) - (int) (n & 7));
	}

}
