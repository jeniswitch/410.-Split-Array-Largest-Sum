class Solution {
    private Integer[][] dp;
    private int m, n;
    private int min;
    public int minFallingPathSum(int[][] matrix) {
        m = matrix.length;
        n = matrix.length;
        dp = new Integer[m][n];
        min = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++) {
            min = Math.min(min, dfs(matrix, 0, j));
        }
        return min;
    }
    private int dfs(int[][] matrix, int i, int j) {
        if(j == n || j < 0) return Integer.MAX_VALUE;
        if(dp[i][j] != null) return dp[i][j];
        if(i == m - 1) return dp[i][j] = matrix[i][j];
        int localMin = matrix[i][j] + Math.min(Math.min(dfs(matrix, i + 1, j - 1), dfs(matrix, i + 1, j)), 
                                dfs(matrix, i + 1, j + 1));
        return dp[i][j] = localMin;
    }
}