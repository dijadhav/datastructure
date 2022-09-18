package ds.stack;

public class RainWaterTrapping {
	static int arr[] = new int[] { 7, 4, 5, 8, 6 };

	// Method for maximum amount of water
	static int findWater(int n) {
		int left[] = new int[n];
		int right[] = new int[n];
		int water = 0;
		left[0] = arr[0];
		for (int i = 1; i < n; i++)
			left[i] = Math.max(left[i - 1], arr[i]);
		right[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--)
			right[i] = Math.max(right[i + 1], arr[i]);
		for (int i = 0; i < n; i++)
			water += Math.min(left[i], right[i]) - arr[i];

		return water;
	}

	public static void main(String[] args) {
		System.out.println(findWater(arr.length));
		System.out.println(trapping_rain_water(arr));

		int[] arr = { 3, 0, 0, 2, 0, 4 };
		int[] maxL = new int[arr.length];
		int max = arr[0];
		for (int i = 0; i < maxL.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
			maxL[i] = max;
		}
		int[] maxR = new int[arr.length];
		max = arr[arr.length - 1];
		for (int i = arr.length - 1; i >= 0; i--) {
			if (max < arr[i]) {
				max = arr[i];
			}
			maxR[i] = max;
		}
		int ans = 0;
		for (int i = 0; i < maxR.length; i++) {
			ans += Math.min(maxL[i], maxR[i]) - arr[i];
		}
		System.out.println(ans);

	}

	public static int trapping_rain_water(int[] A) {
		int res = 0;
		int left_max = 0;
		int right_max = 0;
		int i = 0;
		int j = A.length - 1;
		while (i < j) {
			left_max = Math.max(left_max, A[i]);
			right_max = Math.max(right_max, A[j]);
			if (left_max < right_max) {
				res += left_max - A[i];
				i++;
			} else {
				res += right_max - A[j];
				j--;
			}
		}
		return res;
	}

}
