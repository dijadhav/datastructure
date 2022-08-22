package ds.graph;

import java.util.ArrayList;

public class DFS {
	public static void main(String[] args) {
		int graph[][] = { { 0, 1, 1, 1, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		int V = 5;
		boolean visited[] = new boolean[V];
		ArrayList<Integer> list = new ArrayList<>();
		dfs(graph, list, 0, visited, V);
		list.stream().forEach(x -> {
			System.out.print(x + " ");
		});
	}

	private static void dfs(int[][] graph, ArrayList<Integer> list, int v, boolean[] visited, int V) {
		list.add(v);
		visited[v] = true;
		for (int u = 0; u < V; u++) {
			if (graph[v][u] == 1 && !visited[u]) {
				dfs(graph, list, u, visited, V);
			}
		}
	}

}
