/**
 * 
 */
package algorithm.sliding.window;

import java.util.ArrayList;

/**
 * https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
 * 
 * @author dijadhav
 *
 */
public class MaximumSumSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(100);
		list.add(200);
		list.add(300);
		list.add(400);
		System.out.println("Maximum sum of a subarray of size K:" + maximumSumSubarray(2, list, 4));
	}

	private static int maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {

		int i = 0, j = 0, sum = 0, maxSum = 0;

		while (j < N) {
			sum += Arr.get(j);
			if ((j - i + 1) == K) {
				if (i != 0) {
					sum -= Arr.get(i - 1);
				}

				if (sum > maxSum) {
					maxSum = sum;
				}
				i++;

			}
			j++;

		}
		return maxSum;
	}
}
