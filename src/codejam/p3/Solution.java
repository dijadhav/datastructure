package codejam.p3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			int testCases = sc.nextInt();
			for (int i = 0; i < testCases; i++) {
				int n = sc.nextInt();
				int arr[] = new int[n];
				for (int j = 0; j < arr.length; j++) {
					arr[j] = sc.nextInt();
				}
				Arrays.sort(arr);
				int ans = 1;
				for (int j = 0; j < arr.length; j++) {
					if (arr[j] >= ans) {
						ans += 1;
					}
				}
				ans -= 1;
				System.out.println("Case #" + (i + 1) + ": " + ans);
			}
		} finally {
			if (null != sc)
				sc.close();
		}

	}

}
