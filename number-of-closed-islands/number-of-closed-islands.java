class Solution {
    private final int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int closedIsland(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    count += dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private int dfs(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length) return 0;
        if(grid[i][j] == 1) return 1;
        grid[i][j] = 1;
        return dfs(grid, i + dir[0][0], j + dir[0][1]) & dfs(grid, i + dir[1][0], j + dir[1][1]) 
            & dfs(grid, i + dir[2][0], j + dir[2][1]) & dfs(grid, i + dir[3][0], j + dir[3][1]);
    }        
}