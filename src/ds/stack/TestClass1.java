package ds.stack;

import java.io.*;
import java.util.*;

public class TestClass1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine().trim());
		for (int t_i = 0; t_i < T; t_i++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[][] edges = new int[N - 1][2];
			for (int i_edges = 0; i_edges < N - 1; i_edges++) {
				String[] arr_edges = br.readLine().split(" ");
				for (int j_edges = 0; j_edges < arr_edges.length; j_edges++) {
					edges[i_edges][j_edges] = Integer.parseInt(arr_edges[j_edges]);
				}
			}
			int Q = Integer.parseInt(br.readLine().trim());
			String[] arr_queries = br.readLine().split(" ");
			int[] queries = new int[Q];
			for (int i_queries = 0; i_queries < arr_queries.length; i_queries++) {
				queries[i_queries] = Integer.parseInt(arr_queries[i_queries]);
			}

			String[] out_ = dist_queries(N, edges, Q, queries);
			System.out.print(out_[0]);
			for (int i_out_ = 1; i_out_ < out_.length; i_out_++) {
				System.out.print(" " + out_[i_out_]);
			}

			System.out.println();

		}

		wr.close();
		br.close();
	}

	static String[] dist_queries(int N, int[][] edges, int Q, int[] queries) {
		// Write your code here
		String[] result = new String[Q];
		for (int i = 0; i < Q; i++) {
			result[i] = "NO";
			int d = queries[i];
			for (int j = 1; j <= N; j++) {
				boolean found = false;
				Queue<Integer> queue = new LinkedList<Integer>();
				int dist = 0;
				queue.offer(j);
				boolean visited[] = new boolean[N];
				visited[0] = false;
				while (!queue.isEmpty()) {
					int num = queue.poll();
					if (!visited[num - 1]) {
						dist++;
						for (int m = 0; m < edges.length; m++) {
							int[] nums = edges[m];
							if (nums[0] == num) {
								queue.offer(nums[1]);
							} else if (nums[1] == num) {
								queue.offer(nums[0]);
							}
						}
					}
					visited[num - 1] = true;
					if (dist == d) {
						result[i] = "YES";
						found = true;
						break;
					}
				}
				if (found)
					break;
			}
		}
		return result;
	}
}