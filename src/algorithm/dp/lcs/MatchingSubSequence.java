package algorithm.dp.lcs;

/**
 * Check whether one string is subsequence of other String or not. Here we loop
 * on one string then
 * 
 * @author dijadhav
 *
 */
public class MatchingSubSequence {
	public static void main(String[] args) {
		System.out.println(isSubSequence("abc", "ahbgdc"));
		System.out.println(isSubSequence("axc", "ahbgdc"));
	}

	/**
	 * Here we are going to check s is the subsequence of t
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	private static boolean isSubSequence(String s, String t) {
		int n = t.length();
		int j = 0, cnt = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(j) == t.charAt(i)) {
				j++;
				cnt++;
			}
			if (cnt == s.length())
				return true;
		}
		return false;
	}
}
