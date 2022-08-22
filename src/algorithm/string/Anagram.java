package algorithm.string;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

	public static void main(String[] args) {
		System.out.println(isAnagram("geeksforgeeks", "forgeeksgeeks"));
		System.out.println(isAnagram("allergy", "allergic"));
	}

	public static boolean isAnagram(String a, String b) {
		if (a == null || b == null || a.length() != b.length())
			return false;
		Map<Character, Integer> map1 = new HashMap<>();
		for (char ch : a.toCharArray()) {
			map1.put(ch, map1.getOrDefault(ch, 0) + 1);
		}
		for (char ch : b.toCharArray()) {
			if (map1.size() == 0 || !map1.containsKey(ch))
				return false;
			map1.put(ch, map1.getOrDefault(ch, 0) - 1);
			if (map1.get(ch) == 0)
				map1.remove(ch);
		}
		return map1.isEmpty();
	}

}
