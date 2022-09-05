package algorithm.dp.knapsack;

public class CountofSubsetSum {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3 };
		int sum = 6;
		System.out.println("Count of subset sum for given sum:" + solve(arr, arr.length, sum));
		System.out.println("Count of subset sum for given sum:" + countOfSubsetSum(arr, sum));
	}

	private static int solve(int arr[], int n, int sum) {
		if (n == 0 && sum == 0)
			return 1;
		if (n == 0 && sum != 0)
			return 0;
		if (n != 0 && sum == 0)
			return 1;
		if (arr[n - 1] <= sum)
			return solve(arr, n - 1, sum) + solve(arr, n - 1, sum - arr[n - 1]);
		return solve(arr, n - 1, sum);
	}

	private static int countOfSubsetSum(int[] arr, int sum) {
		int n = arr.length;
		int tab[][] = new int[n + 1][sum + 1];
		tab[0][0] = 1;
		for (int i = 1; i <= sum; i++)
			tab[0][i] = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				if (arr[i - 1] > j)
					tab[i][j] = tab[i - 1][j];

				else {
					tab[i][j] = tab[i - 1][j] + tab[i - 1][j - arr[i - 1]];
				}
			}
		}

		return tab[n][sum];
	}
}
