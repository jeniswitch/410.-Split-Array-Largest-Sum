class Solution {
    private final int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] g, int r, int c) {
        if(r < 0 || c < 0 || r == g.length || c == g[0].length || g[r][c] == '0') {
            return;
        }
        g[r][c] = '0';
        for(int i = 0; i < d.length; i++) {
            dfs(g, r + d[i][0], c + d[i][1]);
        }
    }
}