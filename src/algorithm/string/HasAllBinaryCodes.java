package algorithm.string;

import java.util.ArrayList;
import java.util.List;

public class HasAllBinaryCodes {

	public static void main(String[] args) {
		int k = 2;
		String s = "00110";
		if (k > s.length())
			return ;
		List<String> list = new ArrayList<>();
		for (int i = k; i <= s.length(); i++) {
			String code = s.substring(i - k, i);
			if (!list.contains(code))
				list.add(code);
		}
		System.out.println(list.size() == Math.pow(2, k));
	}

}
