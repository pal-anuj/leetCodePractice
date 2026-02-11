// Last updated: 11/02/2026, 22:55:24
class Solution {
    private int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	private boolean[][] visited;
	private int row;
	private int col;
	private char[][] grid;
    public int numIslands(char[][] grid) {
        this.grid = grid;
		this.row = grid.length;
		this.col = grid[0].length;
        visited = new boolean[row][col];
		int ans = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (!visited[i][j] && grid[i][j] == '1') {
					ans++;
					bfs(i, j);
				}
			}
		}
		return ans;
	}

	private void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList();
		queue.add(new int[] { x, y });
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] arr = queue.poll();
			for (int[] dir : directions) {
				int i = dir[0] + arr[0];
				int j = dir[1] + arr[1];

				if (i < 0 || i >= row || j < 0 || j >= col) {
					continue;
				}
				if (visited[i][j] || grid[i][j] == '0') {
					continue;
				}
				visited[i][j] = true;
				queue.add(new int[] { i, j });
			}
		}
    }
}