package codejam.p1;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			int testCases = sc.nextInt();
			for (int i = 0; i < testCases; i++) {
				int r = 2 * sc.nextInt() + 1;
				int c = 2 * sc.nextInt() + 1;
				System.out.println("Case #" + (i + 1) + ": ");
				char[][] arr = new char[r][c];
				for (int m = 0; m < r; m++) {
					arr[m] = new char[c];
				}

				arr[0][0] = '.';
				arr[0][1] = '.';
				arr[1][1] = '.';
				arr[1][0] = '.';

				for (int m = 0; m < r; m++) {
					for (int n = 0; n < c; n++) {
						if ((m == 0 || m == 1) && (n == 0 || n == 1)) {
							continue;
						} else {
							if (m % 2 != 0) {
								if (n % 2 != 0) {
									arr[m][n] = '.';
									if (m - 1 >= 0) {
										arr[m - 1][n] = '-';
										if (n - 1 >= 0) {
											arr[m - 1][n - 1] = '+';
										}
										if (n + 1 < c) {
											arr[m - 1][n + 1] = '+';
										}
									}
									if (m + 1 < r) {
										arr[m + 1][n] = '-';
									}

								} else {
									arr[m][n] = '|';
								}
							} else {
								if (m > 1) {
									arr[m][0] = '+';
									if (n % 2 == 0) {
										arr[m][n] = '+';
									}else {
										arr[m][n] = '-';
									}
									arr[m][c - 1] = '+';

								}
							}
						}
					}
				}
				for (int m = 0; m < r; m++) {
					for (int n = 0; n < c; n++) {
						System.out.print(arr[m][n]);
					}
					System.out.println();
				}
			}

		} finally {
			if (sc != null)
				sc.close();
		}
	}
}
