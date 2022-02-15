package algorithm;

public class PalindromNumber {

	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
	}

	public static boolean isPalindrome(int x) {
		int num = x;
		int temp = 0;

		while (num != 0) {
			int rem = num % 10;
			num = num / 10;
			temp = temp * 10 + rem;
		}
		return temp == x;
	}
}
