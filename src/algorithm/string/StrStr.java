package algorithm.string;

public class StrStr {
	public static void main(String[] args) {
		System.out.println(strStr("mississippi","issip"));
	}
	public static int strStr(String haystack, String needle) {
		if (null == needle)
			return 0;
		if (null == haystack || needle.length() > haystack.length())
			return -1;

		int index = -1;
		int i = 0, j = 0;
		int n = haystack.length();
		int m = needle.length();
		for (; i < n && j < m;) {
			if (needle.charAt(j) == haystack.charAt(i)) {
				if (index == -1) {
					index = i;
				}
				i++;
				j++;
			} else {
				i++;
				j = 0;
				index = -1;
			}
		}
		return index;
	}
}
