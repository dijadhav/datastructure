
import java.io.*;
import java.util.*;

public class CandidateCode {
	/**
	 * public static void main(String args[]) throws Exception { Scanner sc = null;
	 * try { sc = new Scanner(System.in); int h1 = sc.nextInt(); int m1 =
	 * sc.nextInt(); int h2 = sc.nextInt(); int m2 = sc.nextInt(); sc.close();
	 * 
	 * if (m1 < 0) m1 = 0; if (m2 < 0) m2 = 0;
	 * 
	 * if (m1 >= 60) { m1 = m1 % 60; h1 += m1 / 60; } if (m2 >= 60) { m2 = m2 % 60;
	 * h2 += m2 / 60; }
	 * 
	 * if (h1 < 0) h1 = 0;
	 * 
	 * if (h2 < 0) h2 = 0;
	 * 
	 * if (h1 > 23) h1 = h1 % 24;
	 * 
	 * if (h2 > 23) h2 = h2 % 24;
	 * 
	 * int m3 = m1 + m2; int h3 = 0;
	 * 
	 * if (m3 >= 60) { h3 = m3 / 60; m3 = m3 % 60; } h3 += h1 + h2;
	 * 
	 * String out = "";
	 * 
	 * if (h3 > 23) { h3 = h3 % 24; } if (h3 >= 0) { if (h3 > 9) { out += h3 + " ";
	 * } else { out += "0" + h3 + " "; } }
	 * 
	 * if (m3 >= 0) { if (m3 > 9) { out += m3; } else { out += "0" + m3; }
	 * System.out.println(out); } } finally { if (null != sc) { sc.close(); } } }
	 **/
	/*
	 * public static void main(String args[]) throws Exception {
	 * 
	 * Scanner sc = new Scanner(System.in); int h1 = sc.nextInt(); int m1 =
	 * sc.nextInt(); int h2 = sc.nextInt(); int m2 = sc.nextInt(); sc.close();
	 * 
	 * if (m1 < 0) m1 = 0;
	 * 
	 * if (m2 < 0) m2 = 0;
	 * 
	 * if (m1 >= 60) { m1 = m1 % 60; h1 += m1 / 60; } if (m2 >= 60) { m2 = m2 % 60;
	 * h2 += m2 / 60; }
	 * 
	 * if (h1 < 0) h1 = 0;
	 * 
	 * if (h2 < 0) h2 = 0;
	 * 
	 * if (h1 > 23) h1 = h1 % 24;
	 * 
	 * if (h2 > 23) h2 = h2 % 24;
	 * 
	 * int m3 = m1 + m2; int h3 = 0;
	 * 
	 * if (m3 >= 60) { h3 = m3 / 60; m3 = m3 % 60; } h3 += h1 + h2;
	 * 
	 * String out = "";
	 * 
	 * if (h3 > 23) { h3 = h3 % 24; } if (h3 >= 0) { if (h3 > 9) { out += h3 + " ";
	 * } else { out += "0" + h3 + " "; } }
	 * 
	 * if (m3 >= 0) { if (m3 > 9) { out += m3; } else { out += "0" + m3; }
	 * System.out.println(out); } }
	 */
	public static void main(String args[]) throws Exception {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			int testCases = sc.nextInt();
			for (int i = 0; i < testCases; i++) {
				int numberOfGifts = sc.nextInt();
				int gifts = sc.nextInt();
				if (numberOfGifts >= 1 && numberOfGifts <= gifts) {
					long arr[] = new long[gifts];
					for (int j = 0; j < gifts; j++) {
						arr[j] = sc.nextLong();
					}
					Arrays.sort(arr);
					long amount = 0;
					for (int k = 0; k < numberOfGifts; k++) {
						amount += arr[k];
					}
					System.out.println(amount);
				}
			}
		} finally {
			if (sc != null)
				sc.close();
		}
	}
}