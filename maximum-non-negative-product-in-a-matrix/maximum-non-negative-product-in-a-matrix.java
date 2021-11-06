class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long MOD = (long)1e9 + 7;
        long[][][] dp = new long[m][n][2];
        dp[0][0] = new long[]{grid[0][0], grid[0][0]};
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) continue;
                if(i == 0) {
                    dp[i][j][0] = dp[i][j][1] = grid[i][j] * dp[i][j - 1][0];
                }
                else if(j == 0) {
                    dp[i][j][0] = dp[i][j][1] = grid[i][j] * dp[i - 1][j][0];
                }
                else {
                    long a = grid[i][j] * Math.max(dp[i - 1][j][0], dp[i][j - 1][0]);
                    long b = grid[i][j] * Math.min(dp[i - 1][j][1], dp[i][j - 1][1]);
                    dp[i][j][0] = Math.max(a, b);
                    dp[i][j][1] = Math.min(a, b);
                }
            }
        }
        if(dp[m - 1][n - 1][0] < 0) return -1;
        return (int)(dp[m - 1][n - 1][0] % MOD);
    }
}