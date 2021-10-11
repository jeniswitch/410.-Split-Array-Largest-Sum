class Solution {
    private Integer[][][] dp;
    private int MAX = (int)1e8;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        dp = new Integer[m + 1][n + 1][target + 1];
        int min = dfs(houses, cost, m, n, 0, 0, target);
        return min >= MAX? -1 : min;
    }
    private int dfs(int[] h, int[][] c, int m, int n, int hIdx, int preColor, int target) {
        if(hIdx == m || target < 0) return target == 0 ? 0 : MAX;
        if(dp[hIdx][preColor][target] != null) return dp[hIdx][preColor][target];
        if(h[hIdx] != 0) {
            return dp[hIdx][preColor][target] = dfs(h, c, m, n, hIdx + 1, h[hIdx], target - (h[hIdx] == preColor ? 0 : 1));
        }
        int min = MAX;
        for(int crrColor = 1; crrColor <= n; crrColor++) {
            int val = dfs(h, c, m, n, hIdx + 1, crrColor, target - (crrColor == preColor ? 0 : 1));
            min = Math.min(min, val + c[hIdx][crrColor - 1]);
        }
        return dp[hIdx][preColor][target] = min;
    }
}