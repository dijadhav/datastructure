package algorithm.dp.mcm;

import java.util.HashMap;
import java.util.Map;

public class ScrambledString {
	private static Map<String, Boolean> map = new HashMap<>();

	public static void main(String[] args) {
		String a = "sqksrqzhhmfmlmqvlbnaqcmebbkqfy";
		String b = "abbkyfqemcqnblvqmlmfmhhzqrskqs";
		System.out.println("Is Scrambled:" + solve(a, b));
		System.out.println("Is Scrambled:" + solveMemoizarion(a, b));

	}

	private static boolean solve(String a, String b) {
		/**** Start Base Conditions *****/
		if (isEmpty(a) && isEmpty(b)) {
			return true;
		}
		if (isEmpty(a) || isEmpty(b)) {
			return false;
		}
		a = a.trim();
		b = b.trim();
		if (a.compareTo(b) == 0)
			return true;

		/**** End Base Conditions *****/

		boolean flag = false;
		int n = a.length();
		for (int i = 1; i < a.length(); i++) {
			boolean condition1 = solve(a.substring(0, i), b.substring(0, i)) && solve(a.substring(i), b.substring(i));

			boolean condition2 = solve(a.substring(0, i), b.substring(b.length() - i))
					&& solve(a.substring(i), b.substring(0, b.length() - i));
			if (condition1 || condition2) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	private static boolean solveMemoizarion(String a, String b) {
		/**** Start Base Conditions *****/
		if (isEmpty(a) && isEmpty(b)) {
			return true;
		}
		if (isEmpty(a) || isEmpty(b)) {
			return false;
		}
		a = a.trim();
		b = b.trim();
		if (a.compareTo(b) == 0)
			return true;

		/**** End Base Conditions *****/
		// Memoization
		String key = a + "" + b;
		if (map.containsKey(key))
			return map.get(key);

		boolean flag = false;
		for (int i = 1; i < a.length(); i++) {
			String s1 = a.substring(0, i);
			String s2 = b.substring(0, i);
			boolean r1 = false;
			key = s1 + "" + s2;
			if (map.containsKey(key))
				r1 = map.get(key);
			else {
				r1 = solveMemoizarion(s1, s2);
				map.put(key, r1);
			}

			s1 = a.substring(i);
			s2 = b.substring(i);
			boolean r2 = false;
			key = s1 + "" + s2;
			if (map.containsKey(key))
				r2 = map.get(key);
			else {
				r2 = solveMemoizarion(s1, s2);
				map.put(key, r2);
			}
			boolean condition1 = r1 && r2;

			s1 = a.substring(0, i);
			s2 = b.substring(b.length() - i);
			r1 = false;
			key = s1 + "" + s2;
			if (map.containsKey(key))
				r1 = map.get(key);
			else {
				r1 = solveMemoizarion(s1, s2);
				map.put(key, r1);
			}

			s1 = a.substring(i);
			s2 = b.substring(0, b.length() - i);
			r2 = false;
			key = s1 + "" + s2;
			if (map.containsKey(key))
				r2 = map.get(key);
			else {
				r2 = solveMemoizarion(s1, s2);
				map.put(key, r2);
			}
			boolean condition2 = r1 && r2;

			if (condition1 || condition2) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	private static boolean isEmpty(String str) {
		return null == str || str.trim().isEmpty();
	}

}
