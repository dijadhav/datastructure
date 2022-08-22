package ds.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	public static void main(String[] args) {
		int graph[][] = { { 0, 1, 1, 1, 0 },
				{ 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 }};
		int V = 5;
		int[] result = bfs(graph, V);
		Arrays.stream(result).forEach(x -> {
			System.out.print(x + " ");
		});
	}

	private static int[] bfs(int[][] graph, int V) {
		boolean[] visited = new boolean[V];
		int[] result = new int[V];
		int src = 0;
		visited[src] = true;
		int i = 0;
		result[i++] = src;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(src);
		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (int v = 0; v < graph[u].length; v++) {
				if (graph[u][v] == 1 && !visited[v]) {
					visited[v] = true;
					result[i++] = v;
					queue.offer(v);
				}
			}
		}
		return result;
	}
}
