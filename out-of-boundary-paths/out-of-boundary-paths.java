class Solution {
    private final int MOD = (int)1e9 + 7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer[][][] dp = new Integer[m][n][maxMove + 1];
        return dfs(m, n , maxMove, startRow, startColumn, dp);
    }
    private int dfs(int m, int n , int N, int i, int j, Integer[][][] dp) {
        if(i < 0 || j < 0 || i == m || j == n) return 1;
        if(N == 0) return 0;
        if(dp[i][j][N] != null) return dp[i][j][N];
        return dp[i][j][N] = 
            ((dfs(m, n, N - 1, i + 1, j, dp) +
            dfs(m, n, N - 1, i - 1, j, dp)) % MOD +
            (dfs(m, n, N - 1, i, j + 1, dp) +
            dfs(m, n, N - 1, i, j - 1, dp)) % MOD) % MOD;
    }
}