class Solution {
    private Integer[][] dp;
    public int minimizeTheDifference(int[][] mat, int target) {
        dp = new Integer[mat.length][5000];
        return dfs(mat, 0, target, 0);
    }
    private int dfs(int[][] mat, int r, int target, int sum) {
        if(r == mat.length) {
            return Math.abs(target - sum);
        }
        if(dp[r][sum] != null) return dp[r][sum];
        int res = Integer.MAX_VALUE;
        for(int j = 0; j < mat[0].length; j++) {
            res = Math.min(res, dfs(mat, r + 1, target, sum + mat[r][j]));
        }
        return dp[r][sum] = res;
    }
}