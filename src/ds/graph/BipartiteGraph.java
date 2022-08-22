package ds.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	boolean isBipartite(int[][] graph) {
		int V = graph.length;
		int[] colors = new int[V];
		for (int u = 0; u < V; u++) {
			if (graph[u].length != 0 && colors[u] == 0) {
				colors[u] = 1;
				Queue<Integer> queue = new LinkedList<>();
				queue.offer(u);
				while (!queue.isEmpty()) {
					int m = queue.poll();
					for (int v : graph[m]) {
						if (colors[v] == 0) {
							colors[v] = colors[m] == 1 ? 2 : 1;
							queue.offer(v);
						} else if (colors[v] == colors[m]) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
}
