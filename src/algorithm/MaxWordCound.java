package algorithm;

public class MaxWordCound {

	public static void main(String[] args) {
		String sentences[] = { "alice and bob love leetcode", "i think so too", "this is great thanks very much" };
		System.out.println(mostWordsFoundRecurssion(sentences, sentences.length));
	}

	public int mostWordsFound(String[] sentences) {
		int count = 0;
		if (null != sentences && sentences.length > 0) {
			for (int i = 0; i < sentences.length; i++) {
				String sentence = sentences[i];
				if (null != sentence && !sentence.trim().isEmpty()) {
					if (count < sentence.trim().split(" ").length)
						count = sentence.trim().split(" ").length;
				}
			}
		}
		return count;
	}

	public static int mostWordsFoundRecurssion(String[] sentences, int n) {
		int count = 0;
		if (n > 0) {
			String sentence = sentences[n - 1];
			if (null != sentence && !sentence.trim().isEmpty()) {
				String[] parts = sentence.trim().split(" ");
				if (count < parts.length)
					count = parts.length;
				count = Math.max(count, mostWordsFoundRecurssion(sentences, n - 1));
			}

		}
		return count;
	}

}
