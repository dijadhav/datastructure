package ds.graph;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and
 * '0's (water), return the number of islands.
 * 
 * Input: grid = [ ["1","1","1","1","0"], ["1","1","0","1","0"],
 * ["1","1","0","0","0"], ["0","0","0","0","0"] ] Output: 1 Input: grid = [
 * ["1","1","0","0","0"], ["1","1","0","0","0"], ["0","0","1","0","0"],
 * ["0","0","0","1","1"] ] Output: 3
 * 
 * @author dijadhav
 *
 */
public class CountOfIslands {

	public static void main(String[] args) {
		char[][] grid = new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };
		System.out.println(numIslands(grid));
		 grid = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } };
		System.out.println(numIslands(grid));
	}

	public static int numIslands(char[][] grid) {
		int count = 0;
		if (null != grid && grid.length > 0) {
			int m = grid.length;// Number of rows
			int n = grid[0].length;// Number of columns
			boolean visited[][] = new boolean[m][n];

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					// Process cell from grid which have 1 as value and not yet processed
					if (grid[i][j] == '1' && !visited[i][j]) {
						dfs(grid, i, j, visited);
						count++;
					}
				}
			}
		}

		return count;
	}

	private static void dfs(char[][] grid, int i, int j, boolean[][] visited) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || visited[i][j])
			return;
		// Mark current cell as visited
		visited[i][j] = true;
		grid[i][j] = '0';
		dfs(grid, i - 1, j, visited);
		dfs(grid, i + 1, j, visited);
		dfs(grid, i, j - 1, visited);
		dfs(grid, i, j + 1, visited);
	}
}
