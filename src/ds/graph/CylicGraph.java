package ds.graph;

import java.util.ArrayList;

/**
 * Detect the graph has cycle or not. 
 * 
 * @author dijadhav
 *
 */
public class CylicGraph {
	public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (dfs(visited, adj, i, -1))
				return true;
		}
		return false;
	}

	private boolean dfs(boolean visited[], ArrayList<ArrayList<Integer>> adj, int u, int parent) {
		visited[u] = true;
		ArrayList<Integer> arrayList = adj.get(u);
		if (arrayList != null && !arrayList.isEmpty()) {
			for (int v : adj.get(u)) {
				if (!visited[v]) {
					if (dfs(visited, adj, v, u)) {
						return true;
					}
				} else {
					return true;
				}
			}
		}
		return false;
	}
}
