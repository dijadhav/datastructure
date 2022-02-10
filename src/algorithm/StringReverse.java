package algorithm;

public class StringReverse {

	public static void main(String[] args) {
		System.out.println(reverse("hello"));
		System.out.println(reverse1("hello"));

	}

	private static String reverse(String str) {
		if (null == str || str.trim().isEmpty()) {
			return str;
		}
		return str.charAt(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
	}

	private static String reverse1(String str) {
		if (null == str || str.trim().isEmpty()) {
			return str;
		}
		char arr[] = str.trim().toCharArray();
		for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		return new String(arr);
	}

}
