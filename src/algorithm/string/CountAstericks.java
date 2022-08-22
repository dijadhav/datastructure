package algorithm.string;

public class CountAstericks {
	public static int countAsterisks(String s) {
		boolean start = false, end = false;
		int cnt = 0;
		int total = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '|') {
				if (!start) {
					total += cnt;
					start = true;
					end = false;
					cnt = 0;
				} else if (!end) {
					end = true;
					cnt=0;
					start = false;
				}
			} else if (ch == '*') {
				cnt++;
			}
		}
			total += cnt;
		return total;
	}

	public static void main(String[] args) {
		String s = "*||||**||*||**|**||*|||**";
		System.out.println(countAsterisks(s));
	}
}
