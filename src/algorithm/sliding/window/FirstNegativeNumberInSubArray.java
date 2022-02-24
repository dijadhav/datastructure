/**
 * 
 */
package algorithm.sliding.window;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author dijadhav
 *
 */
public class FirstNegativeNumberInSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long A[] = { -8, 2, 3, -6, 10 };
		int N = 5;
		int K = 2;
		long[] arr = printFirstNegativeIntegerImproved(A, N, K);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static long[] printFirstNegativeIntegerBruteForce(long A[], int N, int K) {
		int i = 0, j = 0;
		long num = 0;
		long[] arr = new long[N - K + 1];
		int index = 0;

		while (j < N) {

			if (num == 0 && A[j] < 0) {
				num = A[j];
			}

			if ((j - i + 1) == K) {
				arr[index] = num;
				index++;
				num = 0;
				i++;
				j = i;
			} else {
				j++;
			}
		}
		return arr;
	}

	public static long[] printFirstNegativeIntegerImproved(long A[], int N, int K) {
		int i = 0, j = 0;
		Queue<Long> queue = new LinkedList<Long>();
		List<Long> list = new ArrayList<>();
		while (j < N) {
			if (A[j] < 0) {
				queue.offer(A[j]);
			}
			if ((j - i + 1) < K) {
				j++;
			} else if ((j - i + 1) == K) {
				if (queue.isEmpty()) {
					list.add(0l);
				} else {
					list.add(queue.peek());
					if (A[i] == queue.peek())
						queue.poll();
				}
				i++;
				j++;
			}
		}
		long[] arr = new long[list.size()];
		for (int l = 0; l < arr.length; l++) {
			arr[l] = list.get(l);
		}
		return arr;
	}

}
