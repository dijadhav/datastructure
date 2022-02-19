
package algorithm.dp.lcs;

public class NumberOfInsertionAndDeletion {
	public static void main(String[] args) {
		String s1 = "heap";
		String s2 = "pea";
		int n = s1.length();
		int m = s2.length();
		int lcsLen = lcsRecurssion(s1, s2, n, m);
		int insertion = m - lcsLen;
		int deletion = n - lcsLen;
		System.out.println(String.format("Number of insertion %d and deletion %d", insertion, deletion));
	}

	private static int lcsRecurssion(String s1, String s2, int n, int m) {
		if (n == 0 || m == 0)
			return 0;
		if (s1.charAt(n - 1) == s2.charAt(m - 1))
			return 1 + lcsRecurssion(s1, s2, n - 1, m - 1);
		else {
			return Math.max(lcsRecurssion(s1, s2, n - 1, m), lcsRecurssion(s1, s2, n, m - 1));
		}
	}

}
