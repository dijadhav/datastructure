package ds.stack;

public class RainWaterTrapping {
	public static void main(String[] args) {
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
}
