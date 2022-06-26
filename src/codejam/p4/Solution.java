package codejam.p4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		long[] arr1 = new long[100009];
		long[] arr2 = new long[100009];
		long[] arr3 = new long[100009];
		long[] arr4 = new long[100009];

		@SuppressWarnings("unchecked")
		List<Integer>[] arr5 = new ArrayList[100009];
		Queue<Integer> queue = new LinkedList<>();
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			int testCases = sc.nextInt();
			for (int t = 0; t < testCases; t++) {
				int N = sc.nextInt();
				for (int i = 0; i <= N; i++) {
					arr5[i] = new ArrayList<Integer>();
				}
				for (int i = 0; i <= N; i++) {
					arr1[i] = arr2[i] = arr3[i] = arr4[i] = 0;
					arr5[i].clear();
				}
				for (int i = 1; i <= N; i++) {
					arr1[i] = sc.nextLong();
				}
				int b;
				for (int i = 1; i <= N; i++) {
					b = sc.nextInt();
					arr2[i] = b;
					arr5[b].add(i);
					arr4[b]++;
				}
				for (int i = 0; i <= N; i++) {
					if (arr4[i] == 0) {
						queue.offer(i);
					}
				}
				long d = 0, e = 0;
				while (!queue.isEmpty()) {
					b = queue.peek();
					queue.poll();
					long c = 1 << 30;
					for (int i = 0; i < arr5[b].size(); i++) {
						if (arr3[arr5[b].get(i)] < c) {
							c = arr3[arr5[b].get(i)];
							d = i;
						}
					}
					if (c == 1073741824) {
						c = 0;
					}
					for (int i = 0; i < arr5[b].size(); i++) {
						if (i != d) {
							e += arr3[arr5[b].get(i)];
						}
					}
					arr3[b] = Math.max(arr1[b], c);
					arr4[(int) arr2[b]]--;
					if (arr4[(int) arr2[b]] == 0) {
						queue.offer((int) arr2[b]);
					}
				}

				System.out.print("Case #" + (t + 1) + ": " + (e + arr3[0]));
			}
		} finally {
			if (null != sc)
				sc.close();
		}

	}
}
