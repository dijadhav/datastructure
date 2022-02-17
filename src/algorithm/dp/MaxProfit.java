package algorithm.dp;

public class MaxProfit {
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
	}

	public static int maxProfit(int[] prices) {
		if (null == prices || prices.length == 0)
			return 0;

		int profit = 0;
		for (int i = 0; i < prices.length; i++) {
			int p1 = prices[i];
			int temp = 0;
			for (int j = i + 1; j < prices.length; j++) {
				int p2 = prices[j];
				if (p2 > p1) {
					if (temp < (p2 - p1))
						temp = p2 - p1;
				}
			}
			if (temp > profit)
				profit = temp;
		}

		return profit;
	}
}
