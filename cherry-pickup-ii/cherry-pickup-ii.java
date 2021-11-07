class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Integer[][][] dp = new Integer[m][n][n];
        return dfs(grid, 0, 0, n - 1, dp);
    }
    private int dfs(int[][] grid, int r, int c1, int c2, Integer[][][] dp) {
        if(r == grid.length) return 0;
        if(dp[r][c1][c2] != null) return dp[r][c1][c2];
        int res = 0, n = grid[0].length;
        for(int i = -1; i <= 1; i++) {
            int newc1 = c1 + i;
            for(int j = -1; j <= 1; j++) {
                int newc2 = c2 + j;
                if(newc1 < n && newc2 < n && newc1 >= 0 && newc2 >= 0)
                res = Math.max(res, dfs(grid, r + 1, newc1, newc2, dp));
            }
        }
        int cherries = c1 == c2? grid[r][c1] : grid[r][c1] + grid[r][c2];
        return dp[r][c1][c2] = res + cherries;
    }
}