class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }
    private int dfs(int[][] grid, int x, int y) {
        if(x < 0 || y < 0 || x == grid.length || y == grid[0].length || grid[x][y] == 0) {
            return 0;
        }
        grid[x][y] = 0;
        return 1 + dfs(grid, x, y + 1) + dfs(grid, x + 1, y) + dfs(grid, x, y - 1) + dfs(grid, x - 1, y);
    }
}