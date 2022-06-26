package codejam.p2;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			int testCases = sc.nextInt();
			for (int t = 0; t < testCases; t++) {
				String r = "IMPOSSIBLE";
				long color = (long) Math.pow(10, 6);
				long arr[][] = new long[3][4];
				long output[] = new long[] { 0, 0, 0, 0 };
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 4; j++) {
						arr[i][j] = sc.nextLong();
					}
				}
				int i = 0;
				while (color != 0 && i < 4) {
					long temp = Math.min(arr[0][i], Math.min(arr[1][i], arr[2][i]));
					if (temp >= 1000000)
						temp = 1000000;
					if (color <= temp)
						temp = color;
					color -= temp;
					output[i] = temp;
					i++;
				}
				System.out.print("Case #" + (i + 1) + ": ");
				if (color == 0) {
					r = "";
					for (i = 0; i < 4; i++) {
						r += output[i] + " ";
					}
				}
				System.out.println(r.trim());
			}
		} finally {
			if (null != sc)
				sc.close();
		}
	}
}
