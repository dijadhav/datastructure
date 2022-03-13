/**
 * 
 */
package ds.stack;

/**
 * @author dijadhav
 *
 */
public class TestClass2 {
	private static int F[];
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int A[] = { 4, 5 };
		int queries[][] = { { 1, 1, 2 }, { 1, 2, 1 } };
		long[] k_step_sum = K_step_sum(2, A, 2, queries);
		for (int i = 0; i < k_step_sum.length; i++) {
			System.out.print(k_step_sum[i] + " ");
		}

	}

	static long[] K_step_sum(int N, int[] A, int Q, int[][] queries) {
		// Write your code here
		long[] result = new long[Q];
		K_step_sum(N, A, queries, result, 0);
		return result;

	}

	private static void K_step_sum(int N, int[] A, int[][] queries, long[] result, int m) {
		if (m >= result.length)
			return;
		int[] query = queries[m];
		int L = query[0];
		int R = query[1];
		int K = query[2];
		int B[] = new int[N + 1];
		int F[] = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			int fi = 0;
			if(F[i]==0) {
				fi = findFactorial(A, K, i,fi,K);
				F[i]=fi;
			}else {
				fi=F[i];
			}
			B[i] = A[0] + fi;
		}

		int sum = 0;

		for (int i = L; i <= R; i++) {
			sum += B[i];
		}

		result[m] = sum;
		K_step_sum(N, A, queries, result, m+1);

	}

	private static int findFactorial(int[] A, int K, int i, int fi,int j) {
		if(j>i)
			return 0;
		fi += A[K * (int) Math.floor(j / K) - 1]+findFactorial(A, K, i, fi, j+1);
		return fi;
	}

}
